package com.springnovel.test.springSecret.bean.ioc;

public class DowJonesNewsPersister implements IFXNewsPersister {
    @Override
    public void persistNews() {
        System.out.println("DowJonesNewsPersister persistNews");
    }
}
