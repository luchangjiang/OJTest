package com.oj.river;

import java.util.*;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 11:19
 **/
public class len8sub {
    private static final int nLen = 8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();
        handle(str1.trim());
        handle(str2.trim());
        sc.close();
    }

    private static void handle(String str){
        int l = str.length();
        int p = nLen - l % nLen;

        if(p<nLen) {
            String pStr = "";
            for (int i = 0; i < p; i++) {
                pStr += "0";
            }
            str = str + pStr.substring(0, p);

            while (true) {
                System.out.println(str.substring(0, nLen));
                if (str.length() <= nLen) break;
                str = str.substring(nLen);
            }
        }
    }
}
