package com.springnovel.test.springSecret.demo;

import com.springnovel.test.springSecret.bean.DowJonesNewsListener;
import com.springnovel.test.springSecret.bean.DowJonesNewsPersister;
import com.springnovel.test.springSecret.bean.FXNewsProvider;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * <p>
 *
 * @author: hzy created on 2018/04/05
 */
public class IoCTest {

    @Test
    public void test_Binding_by_Code_Using_Constructor() {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCodeUsingConstructor(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }

    private static BeanFactory bindViaCodeUsingConstructor(BeanDefinitionRegistry registry) {
        // TODO 为什么这里必须自动注入 AUTOWIRE_NO不行
        int autowireMode = AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR;

        // 创建根对象
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class, autowireMode, true);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class, autowireMode, true);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class, autowireMode, true);

        // 注册到容器中
        registry.registerBeanDefinition("djNewsProvider", newsProvider);
        registry.registerBeanDefinition("fxNewsListener", newsListener);
        registry.registerBeanDefinition("fxNewsPersister", newsPersister);

        // 依赖关系绑定 - 构造函数
        ConstructorArgumentValues argumentValues = new ConstructorArgumentValues();
        argumentValues.addIndexedArgumentValue(0, newsListener);
        argumentValues.addIndexedArgumentValue(1, newsPersister);
        newsProvider.setConstructorArgumentValues(argumentValues);

        return (BeanFactory) registry;
    }

    @Test
    public void test_Binding_by_Code_Using_Setter() {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCodeUsingSetter(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }

    private static BeanFactory bindViaCodeUsingSetter(BeanDefinitionRegistry registry) {

        // TODO 为什么这里不自动注入也可以
        int autowireMode = AbstractBeanDefinition.AUTOWIRE_NO;

        // 创建根对象
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class, autowireMode, true);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class, autowireMode, true);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class, autowireMode, true);

        // 注册到容器中
        registry.registerBeanDefinition("djNewsProvider", newsProvider);
        registry.registerBeanDefinition("djListener", newsListener);
        registry.registerBeanDefinition("djPersister", newsPersister);

        // 依赖关系绑定 - setter
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("fxNewsListener", newsListener));
        propertyValues.addPropertyValue(new PropertyValue("fxNewsPersister", newsPersister));
        newsProvider.setPropertyValues(propertyValues);

        return (BeanFactory) registry;
    }
}
