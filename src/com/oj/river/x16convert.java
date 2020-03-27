package com.oj.river;

import java.lang.Math;
import java.util.*;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 11:45
 **/
public class x16convert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String str = sc.nextLine();
            System.out.println(String.valueOf(handle(str.substring(2))));
        }
        sc.close();
    }

    private static int handle(String str){
        int n = 0;
        int ret=0;
        while (n<str.length()){
            char c = str.charAt(str.length() - n -1);
            int temp=0;
            if(c >= '0' && c<='9'){
                temp=c-'0';
            }else if(c>='A' && c<='Z'){
                temp = c -'A'+10;
            }else if(c>='a' && c<='z'){
                temp = c -'a'+10;
            }
            else{
                break;
            }
            ret += temp*Math.pow(16,n);
            n++;
        }
        return ret;
    }
}
