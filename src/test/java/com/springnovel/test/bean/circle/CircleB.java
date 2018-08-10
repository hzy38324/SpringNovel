package com.springnovel.test.bean.circle;

/**
 * Created by hongzeyang
 * Time 2018/7/31 下午7:24
 * Desc
 */
public class CircleB {

    private CircleA circleA;

    private String bName;


    public String getbName() {
        return bName;
    }


    public void setbName(String bName) {
        this.bName = bName;
    }


    public CircleA getCircleA() {
        return circleA;
    }


    public void setCircleA(CircleA circleA) {
        this.circleA = circleA;
    }


    @Override
    public String toString() {
        return "CircleB{" + "bName='" + bName + '\'' + '}';
    }
}
