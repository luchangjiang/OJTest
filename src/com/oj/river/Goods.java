package com.oj.river;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 16:55
 **/
public class Goods{
    private int price;
    private int weight;
    private int parent;
    private int score;

    public Goods(int price, int weight, int parent){
        this.price = price;
        this.weight = weight;
        this.parent = parent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    private int getScore(){
        return price*weight;
    }
}
