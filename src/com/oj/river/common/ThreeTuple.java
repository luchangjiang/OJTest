package com.oj.river.common;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-15 11:00
 **/
public class ThreeTuple {
    private int u;
    private int v;
    private int w;
    public ThreeTuple(int u, Integer v, int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public Integer getU() {
        return u;
    }

    public Integer getV() {
        return v;
    }

    public Integer getW() {
        return w;
    }

    public String toString(){
        return u + ":" + v + ":" + w;
    }
}
