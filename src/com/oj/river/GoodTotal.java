package com.oj.river;

import java.util.*;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 16:37
 **/
public class GoodTotal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int num = sc.nextInt();

        List<Goods> goodsList = new ArrayList<>();
        for(int i=0;i<num;i++){
            String[] line =sc.nextLine().split("\\s+");

            Goods goods = new Goods(Integer.parseInt(line[0]), Integer.parseInt(line[1]),Integer.parseInt(line[2]));
            goodsList.add(goods);
        }


    }


}
