package com.oj.river;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-08 20:38
 **/
import java.util.*;
public class rect{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                int start = i*(i+1)/2 + 1;
                int step = i + 2;
                for(int j=0;j<n-i;j++){
                    sb.append(start).append(" ");
                    start +=step;
                    step++;

                }
                sb.setCharAt(sb.toString().length()-1, '\n');
            }
            sb.deleteCharAt(sb.toString().length()-1);
            System.out.println(sb.toString());
        }
        sc.close();
    }
}