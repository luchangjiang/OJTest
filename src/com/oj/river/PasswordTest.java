package com.oj.river;

import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 22:58
 **/
public class PasswordTest {
    private final static String dict1="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private final static String dict2="bcdefghijklmnopqrstuvwxyza222333444555666777788899991234567890";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plainText = sc.next();
        char[] plains = plainText.toCharArray();
        String password="";
        for(int i=0;i<plains.length;i++){
            password += getPwdLetter(plains[i]);
        }
        System.out.println(password);
        sc.close();
    }
    private static String getPwdLetter(char plain){
        char[] arr1 = dict1.toCharArray();
        char[] arr2 = dict2.toCharArray();
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==plain){
                return String.valueOf(arr2[i]);
            }
        }
        return "";
    }

}
