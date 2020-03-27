package com.oj.river;

import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 13:11
 **/
public class double2Int {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();

        System.out.println(getReturn(d));

        sc.close();
    }

    private static int getReturn(double d){
        int i= (int)d;
        return (d-i)>=0.5?i+1:i;
    }
}
