package com.springnovel.mybatis.mapper;

import com.springnovel.mybatis.model.Pet;

import java.util.List;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/24
 */
public interface PetMapper {
    List<Pet> getPets(String owner);

    boolean save(Pet pet);

    boolean deleteAll();
}
