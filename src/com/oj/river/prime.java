package com.oj.river;


import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 12:39
 **/
public class prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long num = sc.nextLong();

        if(num<2){
            sc.close();
            return;
        }
        System.out.println(getResult(num));

        sc.close();
    }

    private static String getResult(Long num){
        StringBuilder sb = new StringBuilder();

        int idx = 2;
        while (idx <= num){
            if(num % idx == 0){
                sb.append(idx).append(" ");

                if(idx == num) {
                    break;
                }
                else {
                    num = num / idx;
                }
            }
            else{
                idx++;
            }
        }
        return sb.toString();
    }
}
