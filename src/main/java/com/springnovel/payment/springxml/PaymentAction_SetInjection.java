package com.springnovel.payment.springxml;

import com.springnovel.dao.IOrderDao;
import com.springnovel.perfectlogger.ILogger;
import org.springframework.beans.factory.annotation.Required;

import java.math.BigDecimal;

public class PaymentAction_SetInjection {

    private ILogger logger;
    private IOrderDao orderDao;

    public PaymentAction_SetInjection(ILogger logger) {
        super();
        this.logger = logger;
    }

    @Required
    public void setOrderDao(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void pay(BigDecimal payValue) {
        logger.log("pay begin, payValue is " + payValue);

        // do otherthing
        // ...

        logger.log("pay end");
    }

    public void updateOrderAfterPayment(String orderId) {
        orderDao.updateOrderAfterPayment(orderId);
    }

}