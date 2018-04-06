package com.springnovel.test.springSecret.bean;

public class DowJonesNewsPersister implements IFXNewsPersister {
    @Override
    public void persistNews() {
        System.out.println("DowJonesNewsPersister persistNews");
    }
}
