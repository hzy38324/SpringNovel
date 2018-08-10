package com.springnovel.test.tx;

import com.springnovel.mybatis.model.Pet;
import com.springnovel.mybatis.service.PetService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/24
 */
public class DeclareTxDemo {

    private ApplicationContext context;

    private PetService petService;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("db-mybatis-declare-tx.xml");
        petService = (PetService) context.getBean("petService");

        petService.deleteAll();
        Pet pet = new Pet(1, "little dog", "Alice", "dog", 1);
        petService.save(pet);
    }

    @Test
    public void test_TxAnnotation() {
        Pet pet = new Pet(2, "little dog", "Tome", "dog", 1);
        try {
            petService.deleteAllAndSaveDeclareTx(pet);
        } catch (Throwable e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    public void test_BatchSaveUsingRequireNew() {
        long begin = System.currentTimeMillis();
        Pet pet = new Pet("little dog", "Tome", "dog", 1);
        petService.batchSaveUsingRequireNew(pet, 100);
        long cost = System.currentTimeMillis() - begin;
        System.out.println("cost: " + cost);
    }

    @Test
    public void test_BatchSaveUsingNested() {
        long begin = System.currentTimeMillis();
        Pet pet = new Pet("little dog", "Tome", "dog", 1);
        petService.batchSaveUsingNested(pet, 100);
        long cost = System.currentTimeMillis() - begin;
        System.out.println("cost: " + cost);
    }

    @Test
    public void test_saveUsingNested() {
        Pet pet = new Pet("little dog", "Tome", "dog", 1);
        petService.saveUsingNested(pet);
    }

    @Test
    public void test_saveUsingSERIALIZABLE() {
        Pet pet = new Pet("little dog", "Tome", "dog", 1);
        petService.saveUsingSERIALIZABLE(pet);
    }
}
