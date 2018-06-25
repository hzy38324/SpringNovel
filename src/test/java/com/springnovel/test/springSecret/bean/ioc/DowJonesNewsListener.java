package com.springnovel.test.springSecret.bean.ioc;

/**
 * <p>
 *
 * @author: hzy created on 2018/04/05
 */
public class DowJonesNewsListener implements IFXNewsListener {
    @Override
    public void listenNews() {
        System.out.println("DowJonesNewsListener listen");
    }
}
