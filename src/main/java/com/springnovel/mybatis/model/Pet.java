package com.springnovel.mybatis.model;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/24
 */
public class Pet {
    private int id;
    private String name;
    private String owner;
    private String species;
    private int sex;

    public Pet() {
    }

    public Pet(int id, String name, String owner, String species, int sex) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.species = species;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", species='" + species + '\'' +
                ", sex=" + sex +
                '}';
    }
}
