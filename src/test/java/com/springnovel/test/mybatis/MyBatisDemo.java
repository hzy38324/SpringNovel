package com.springnovel.test.mybatis;

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
public class MyBatisDemo {

    private ApplicationContext context;

    private PetService petService;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("db-mybatis.xml");
        petService = (PetService) context.getBean("petService");

        petService.deleteAll();
        Pet pet = new Pet("little dog","Alice","dog",1);
        petService.save(pet);
    }

    @Test
    public void test1() {
        List<Pet> pets = petService.findPetsByOwner("Alice");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    @Test
    public void test2_No_Transaction() {
        Pet pet = new Pet("little dog","Tome","dog",1);
        try {
            petService.deleteAllAndSave(pet);
        } catch (Exception e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findPetsByOwner("Alice");
        assertEquals(0, pets.size());
    }

    @Test
    public void test3_TSTTemplate() {
        Pet pet = new Pet("little dog","Tome","dog",1);
        try {
            petService.deleteAllAndSaveUsingTSTTemplate(pet);
        } catch (Exception e) {
            System.out.println("expected failure");
        }
        List<Pet> pets = petService.findPetsByOwner("Alice");
        assertEquals(1, pets.size());
    }
}
