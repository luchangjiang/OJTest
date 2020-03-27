package com.oj.river;

import java.util.*;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-15 19:45
 **/
public class EvalTest {
    private static int index=0;
    private static char[] chs;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String line = sc.nextLine().replace(" ","");
            chs = line.toCharArray();
            int sum=getNum();
            while (index<chs.length){
                if(chs[index]=='+'){
                    index++;
                    sum += getNum();
                }else if(chs[index]=='-'){
                    index++;
                    sum -=getNum();
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }

    private static int getNum(){
        int tmp = chs[index] - '0';
        int res = tmp;
        index++;
        while (index<chs.length){
            if(chs[index]>='0'&&chs[index]<='9'){
                res = res*10 + (chs[index] - '0');
                index++;
            }else if(chs[index] == '*'){
                index++;
                return res * getNum();
            }else{
                break;
            }
        }
        return res;
    }

}
