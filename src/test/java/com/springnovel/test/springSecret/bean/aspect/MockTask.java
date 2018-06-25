package com.springnovel.test.springSecret.bean.aspect;

/**
 * <p>
 *
 * @author: hzy created on 2018/04/06
 */
public class MockTask implements ITask {
    @Override
    public void execute() {
        System.out.println("do MockTask");
    }
}
