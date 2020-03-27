package com.oj.river;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-08 10:31
 **/
import java.util.*;
public class StringSeq{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                char c = (char)(i+'A');
                for(int j=0;j<line.length();j++){
                    char a = line.charAt(j);
                    if(c==a||c==a-32){
                        sb.append(a);
                    }
                }
            }
            for(int j=0;j<line.length();j++){
                char c = line.charAt(j);
                if(!(c>='A'&&c<='Z')&&!(c>='a'&&c<='z')){
                    sb.insert(j,c);
                }
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
