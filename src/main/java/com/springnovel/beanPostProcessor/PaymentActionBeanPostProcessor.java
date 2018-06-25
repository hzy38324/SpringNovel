package com.springnovel.beanPostProcessor;

import com.springnovel.payment.springxml.PaymentAction;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <p>
 *
 * @author: hzy created on 2018/06/11
 */
public class PaymentActionBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PaymentAction) {
            ((PaymentAction) bean).setPostBeanName("hzy-postBeanName");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PaymentAction) {
            String postBeanName = ((PaymentAction) bean).getPostBeanName();
            ((PaymentAction) bean).setPostBeanName(postBeanName + "-hzy");
        }
        return bean;
    }
}
