package com.springnovel.payment.springxml;

import com.springnovel.dao.IOrderDao;
import com.springnovel.perfectlogger.ILogger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

public class PaymentAction implements BeanNameAware, ApplicationContextAware, InitializingBean {

    private ILogger logger;
    private IOrderDao orderDao;
    private String beanName;
    private String postBeanName;
    private ApplicationContext applicationContext;

    public PaymentAction(ILogger logger) {
        super();
        this.logger = logger;
    }

    public PaymentAction(ILogger logger, IOrderDao orderDao) {
        super();
        this.logger = logger;
        this.orderDao = orderDao;
    }

    public void pay(BigDecimal payValue) {
        logger.log("pay begin, payValue is " + payValue + ", beanName is " + beanName + ", postBeanName is " + postBeanName);

        // do otherthing
        // ...

        logger.log("pay end");
    }

    public void updateOrderAfterPayment(String orderId) {
        orderDao.updateOrderAfterPayment(orderId);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getPostBeanName() {
        return postBeanName;
    }

    public void setPostBeanName(String postBeanName) {
        this.postBeanName = postBeanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.log("afterPropertiesSet");
    }

    public void initIt(){
        logger.log("init it");
    }

    @PostConstruct
    public void postConstruct(){
        logger.log("postConstruct");
    }
}