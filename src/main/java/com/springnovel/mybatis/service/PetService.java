package com.springnovel.mybatis.service;

import com.springnovel.mybatis.mapper.PetMapper;
import com.springnovel.mybatis.model.Pet;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/24
 */
public class PetService {

    private PetSaveService petSaveService;

    private PetMapper petMapper;

    private TransactionTemplate transactionTemplate;

    private PlatformTransactionManager transactionManager;

    public PetSaveService getPetSaveService() {
        return petSaveService;
    }

    public void setPetSaveService(PetSaveService petSaveService) {
        this.petSaveService = petSaveService;
    }

    public PetMapper getPetMapper() {
        return petMapper;
    }

    public void setPetMapper(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public List<Pet> findPetsByOwner(String owner) {
        return petMapper.getPets(owner);
    }

    public boolean deleteAll() {
        return petMapper.deleteAll();
    }

    public List<Pet> findAll() {
        return petMapper.findAll();
    }

    public boolean save(Pet pet) {
        return petMapper.save(pet);
    }

    public void deleteAllAndSave(Pet pet) {
        petMapper.deleteAll();
        if ("Tome".equals(pet.getOwner())) {
            throw new UnsupportedOperationException();
        }
        petMapper.save(pet);
    }

    public void deleteAllAndSaveUsingTSTTemplate(final Pet pet) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                petMapper.deleteAll();
                if ("Tome".equals(pet.getOwner())) {
                    throw new UnsupportedOperationException();
                }
                petMapper.save(pet);
            }
        });
    }

    public void deleteAllAndSaveUsingTxManager(final Pet pet) throws Throwable {
        DefaultTransactionDefinition defaultTxDefinition = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(defaultTxDefinition);
        try {
            petMapper.deleteAll();
            if ("Tome".equals(pet.getOwner())) {
                throw new UnsupportedOperationException();
            }
            petMapper.save(pet);
        } catch (Throwable e) {
            transactionManager.rollback(txStatus);
            throw e;
        }
        transactionManager.commit(txStatus);
    }

    public void createTwoPetByTwoTx(final Pet pet) throws Throwable {
        DefaultTransactionDefinition defaultTxDefinition = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(defaultTxDefinition);
        try {
            petMapper.deleteAll();
            if ("Tome".equals(pet.getOwner())) {
                throw new UnsupportedOperationException();
            }
            petMapper.save(pet);

            // 新开一个事务，这个事务如果失败，不会影响外部事务
            DefaultTransactionDefinition txDefinitionRequireNew = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            TransactionStatus txStatusNew = transactionManager.getTransaction(txDefinitionRequireNew);
            try {
                if ("Mike".equals(pet.getOwner())) {
                    throw new UnsupportedOperationException();
                }
            } catch (Throwable e) {
                transactionManager.rollback(txStatusNew);
                throw e;
            }
            transactionManager.commit(txStatusNew);

        } catch (Throwable e) {
            transactionManager.rollback(txStatus);
            throw e;
        }
        transactionManager.commit(txStatus);
    }

    @Transactional
    public void deleteAllAndSaveDeclareTx(Pet pet) {
        petMapper.deleteAll();
        if ("Tome".equals(pet.getOwner())) {
            throw new UnsupportedOperationException();
        }
        petMapper.save(pet);
    }

    @Transactional
    public void saveUsingNested(Pet pet) {
        petSaveService.saveUsingNested(pet);
    }

    @Transactional
    public void batchSaveUsingRequireNew(Pet pet, int num) {
        IntStream.rangeClosed(1, num)
                .forEach(i -> petSaveService.saveUsingRequireNew(pet));
    }

    @Transactional
    public void batchSaveUsingNested(Pet pet, int num) {
        IntStream.rangeClosed(1, num)
                .forEach(i -> petSaveService.saveUsingNested(pet));
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void saveUsingSERIALIZABLE(Pet pet) {
        petMapper.save(pet);
    }
}
