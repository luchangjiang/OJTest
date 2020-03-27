package com.oj.river;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-22 20:23
 **/
public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if(line==null||"".equals(line)){
                break;
            }
            int n = Integer.parseInt(sc.nextLine());

            StringBuilder sb = new StringBuilder();
            int m=0;
            while (m<n){
                if(line.charAt(m)>=19968){
                    if(m>=n-1){
                        break;
                    }
                    n--;
                    sb.append(line.substring(m,m+1));
                    m++;
                }else{
                    sb.append(line.substring(m,m+1));
                    m++;
                }

            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
