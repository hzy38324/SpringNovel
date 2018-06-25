package com.springnovel.test.springSecret.demo;

import com.springnovel.test.springSecret.bean.aspect.*;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 *
 * @author: hzy created on 2018/04/06
 */
public class AspectTest {

    /**
     * 模拟Spring如何使用JDK Proxy创建一个代理对象
     */
    @Test
    public void test_Aspect_Using_JDK_Proxy() {
        MockTask mockTask = new MockTask();
        // 创建代理工厂（织入器），将要代理的对象传进去
        ProxyFactory weaver = new ProxyFactory(mockTask);
        // optional
        weaver.setInterfaces(new Class[]{ITask.class});

        // 定义切面
        defineAdvisor(weaver);

        // 获取代理对象
        ITask proxy = (ITask) weaver.getProxy();
        System.out.println("proxy is " + proxy.getClass());
        proxy.execute();
    }

    /**
     * 模拟Spring如何使用CGLIB创建一个代理对象
     */
    @Test
    public void test_Aspect_Using_CGLIB() {
        TaskWithoutInterface taskWithoutInterface = new TaskWithoutInterface();
        // 创建代理工厂（织入器），将要代理的对象传进去
        ProxyFactory weaver = new ProxyFactory(taskWithoutInterface);

        // 定义切面
        defineAdvisor(weaver);

        // 获取代理对象
        TaskWithoutInterface proxy = (TaskWithoutInterface) weaver.getProxy();
        System.out.println("proxy is " + proxy.getClass());
        proxy.execute();
    }

    private void defineAdvisor(ProxyFactory weaver) {
        // 创建切面
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        // 指定PointCut，即要在哪里织入
        advisor.setMappedName("execute");
        // 指定Advice，即要织入什么
        advisor.setAdvice(new LogMethodInterceptor());
        weaver.addAdvisor(advisor);
    }

    /**
     * 将test_Aspect_Using_JDK_Proxy手动构造代理对象的例子，
     * 改为通过配置文件实现控制反转，交给Spring容器去创建对象
     */
    @Test
    public void test_Spring_AOP_With_IOC() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect-manual.xml");
        ITask task = (ITask) context.getBean("taskProxy");
        task.execute();
    }

    /**
     * 将test_Spring_AOP_With_IOC手动配置ProxyFactoryBean，改为让Spring自动检测生成代理
     */
    @Test
    public void test_Spring_AOP_With_IOC_Auto_Proxy() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect-auto-by-name.xml");
        ITask task = (ITask) context.getBean("mockTask");
        task.execute();
    }

    /**
     * 模拟Spring如何通过一个用AspectJ语言标识的切面创建代理对象
     */
    @Test
    public void test_AOP_by_AspectJ_Manual(){
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(new MockTask());
        proxyFactory.addAspect(LogAspect.class);
        ITask task = proxyFactory.getProxy();
        task.execute();
    }

    /**
     * Spring自动创建AspectJ语言标识的切面
     * 通过注入AnnotationAwareAspectJAutoProxyCreator
     */
    @Test
    public void test_AOP_by_AspectJ_Auto_With_Inject_AutoProxyCreator() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect-auto-by-aspectj-with-creator.xml");
        ITask task = (ITask) context.getBean("mockTask");
        task.execute();
    }

    /**
     * Spring自动创建AspectJ语言标识的切面
     * 通过开启自动proxy开关
     */
    @Test
    public void test_AOP_by_AspectJ_Auto_With_AOP_XSD() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspect-auto-by-aspectj-with-aop-xsd.xml");
        ITask task = (ITask) context.getBean("mockTask");
        task.execute();
    }
}
