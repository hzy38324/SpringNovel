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
public class WrongTxManagerDemo {

    private ApplicationContext context;

    private PetService petService;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("db-mybatis-wrong-tx-manager.xml");
        petService = (PetService) context.getBean("petService");

        petService.deleteAll();
        Pet pet = new Pet(1, "little dog", "Alice", "dog", 1);
        petService.save(pet);
    }

    @Test
    public void test() {
        List<Pet> pets = petService.findAll();
        assertEquals(1, pets.size());
    }
}
