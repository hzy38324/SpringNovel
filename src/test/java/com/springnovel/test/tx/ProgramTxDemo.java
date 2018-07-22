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
public class ProgramTxDemo {

    private ApplicationContext context;

    private PetService petService;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("db-mybatis.xml");
        petService = (PetService) context.getBean("petService");

        petService.deleteAll();
        Pet pet = new Pet(1, "little dog", "Alice", "dog", 1);
        petService.save(pet);
    }

    @Test
    public void test_find() {
        List<Pet> pets = petService.findAll();
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    @Test
    public void test_No_Transaction() {
        Pet pet = new Pet(2, "little dog", "Tome", "dog", 1);
        try {
            petService.deleteAllAndSave(pet);
        } catch (Exception e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findAll();
        assertEquals(0, pets.size());
    }

    @Test
    public void test_TxTemplate() {
        Pet pet = new Pet(2, "little dog", "Tome", "dog", 1);
        try {
            petService.deleteAllAndSaveUsingTSTTemplate(pet);
        } catch (Throwable e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    public void test_TxManager() {
        Pet pet = new Pet(2, "little dog", "Tome", "dog", 1);
        try {
            petService.deleteAllAndSaveUsingTxManager(pet);
        } catch (Throwable e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    public void test_createTwoPetByTwoTx_1() {
        Pet pet = new Pet(2, "little dog", "Tome", "dog", 1);
        try {
            petService.createTwoPetByTwoTx(pet);
        } catch (Throwable e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    public void test_createTwoPetByTwoTx_2() {
        Pet pet = new Pet(2, "little dog", "Mike", "dog", 1);
        try {
            petService.createTwoPetByTwoTx(pet);
        } catch (Throwable e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    public void test_createTwoPetByTwoTx_3() {
        Pet pet = new Pet(2, "little dog", "David", "dog", 1);
        try {
            petService.createTwoPetByTwoTx(pet);
        } catch (Throwable e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findAll();
        assertEquals(1, pets.size());
    }
}
