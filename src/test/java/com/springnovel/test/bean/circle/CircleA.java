package com.springnovel.test.bean.circle;

/**
 * Created by hongzeyang
 * Time 2018/7/31 下午7:24
 * Desc
 */
public class CircleA {

    private CircleB circleB;

    private String aName;


    public String getaName() {
        return aName;
    }


    public void setaName(String aName) {
        this.aName = aName;
    }


    public CircleB getCircleB() {
        return circleB;
    }


    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }


    @Override
    public String toString() {
        return "CircleA{" + "aName='" + aName + '\'' + '}';
    }
}
