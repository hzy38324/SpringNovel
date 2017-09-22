package com.springnovel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springnovel.dao.IOrderDao;
import com.springnovel.payment.springmixed.PaymentActionMixed;

@Configuration
@ComponentScan(basePackageClasses={IOrderDao.class,PaymentActionMixed.class})
public class PaymentConfig {

}
