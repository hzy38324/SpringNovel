package com.springnovel.test.springSecret.bean.ioc;

/**
 * <p>
 *
 * @author: hzy created on 2018/04/05
 */
public class FXNewsProvider {

    private IFXNewsListener fxNewsListener;
    private IFXNewsPersister fxNewsPersister;

    public FXNewsProvider() {
    }

    public FXNewsProvider(IFXNewsListener fxNewsListener, IFXNewsPersister fxNewsPersister) {
        this.fxNewsListener = fxNewsListener;
        this.fxNewsPersister = fxNewsPersister;
    }

    public IFXNewsListener getFxNewsListener() {
        return fxNewsListener;
    }

    public void setFxNewsListener(IFXNewsListener fxNewsListener) {
        this.fxNewsListener = fxNewsListener;
    }

    public IFXNewsPersister getFxNewsPersister() {
        return fxNewsPersister;
    }

    public void setFxNewsPersister(IFXNewsPersister fxNewsPersister) {
        this.fxNewsPersister = fxNewsPersister;
    }

    public void getAndPersistNews() {
        System.out.println("go into getAndPersistNews");
        fxNewsListener.listenNews();
        fxNewsPersister.persistNews();
        System.out.println("end getAndPersistNews");
    }
}
