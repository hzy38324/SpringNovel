package com.springnovel.mybatis.service;

import com.springnovel.mybatis.mapper.PetMapper;
import com.springnovel.mybatis.model.Pet;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/24
 */
public class PetService {
    private PetMapper petMapper;

    private TransactionTemplate transactionTemplate;

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

    public List<Pet> findPetsByOwner(String owner) {
        return petMapper.getPets(owner);
    }

    public boolean deleteAll() {
        return petMapper.deleteAll();
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
}
