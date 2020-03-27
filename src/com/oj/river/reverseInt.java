package com.oj.river;

import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 15:30
 **/
public class reverseInt {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        char[] arr = String.valueOf(a).toCharArray();
        String result="";
        for(int i=arr.length-1;i>=0;i--){
            if(result.indexOf(String.valueOf(arr[i]))<0){
                result +=String.valueOf(arr[i]);
            }
        }

        System.out.print(result);
        sc.close();
    }
}
