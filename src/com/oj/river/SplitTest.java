package com.oj.river;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-08 17:02
 **/
import java.util.*;
public class SplitTest{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--)
            sb.append(sp[i] + " ");
        System.out.println(sb.toString().trim());
        sc.close();


    }
}
