package com.oj.river;

import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-21 21:51
 **/
public class BallLife {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            double h = sc.nextDouble();
            double dis = 0;
            int m=5;
            while (m>0){
                dis +=h;
                h /=2;
                dis +=h;
                m--;
            }
            System.out.println(dis-h);
            System.out.println(String.format("%.5f", h));
        }
    }


}
