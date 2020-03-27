package com.oj.river;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-22 10:57
 **/
public class Num2English {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();

            String ret = parse(num);
            System.out.println(ret.trim());
        }
    }

    private static Map<Integer, String> getDict() {
        Map<Integer, String> dict = new HashMap<>();
        dict.put(0, "zero");
        dict.put(1, "one");
        dict.put(2, "two");
        dict.put(3, "three");
        dict.put(4, "four");
        dict.put(5, "five");
        dict.put(6, "six");
        dict.put(7, "seven");
        dict.put(8, "eight");
        dict.put(9, "nine");
        dict.put(10, "ten");
        dict.put(11, "eleven");
        dict.put(12, "twelve");
        dict.put(13, "thirteen");
        dict.put(14, "fourteen");
        dict.put(15, "fifteen");
        dict.put(16, "sixteen");
        dict.put(17, "seventeen");
        dict.put(18, "eighteen");
        dict.put(19, "nineteen");
        return dict;
    }

    private static String parse(int num) {
        Map<Integer, String> dict = getDict();
        int numLen = String.valueOf(num).length();
        if (numLen <= 2) {
            if(num < 20){
                return dict.get(num);
            }else if(num < 30){
                int k = num % 10;
                return k != 0 ? "twenty "+ dict.get(k): "twenty";
            }else if(num<40){
                return num % 10 != 0 ? "thirty " + dict.get(num % 10): "thirty";
            }else if(num<50){
                return num % 10 != 0 ? "forty " + dict.get(num % 10): "forty";
            }else if(num<60){
                return num % 10 != 0 ? "fifty " + dict.get(num % 10): "fifty";
            }else if(num<70){
                return num % 10 != 0 ? "sixty " + dict.get(num % 10): "sixty";
            }else if(num<80){
                return num % 10 != 0 ? "seventy " + dict.get(num % 10): "seventy";
            }else if(num<90){
                return num % 10 != 0 ? "eighty " + dict.get(num % 10): "eighty";
            }else if(num<100){
                return num % 10 != 0 ? "ninety " + dict.get(num % 10): "ninety";
            }
        } else if (numLen == 3) {
            int a = num / 100;
            int b = num % 100;
            String handred = dict.get(a) + " hundred ";
            if (b > 0) {
                String teen = parse(b);
                handred += "and " + teen;
            }
            return handred;
        } else if (numLen >= 4 && numLen <= 6) {
            int t = num / 1000;
            int h = num % 1000;
            String thousand = parse(t) + " thousand ";
            if (h >= 100) {
                thousand += parse(h);
            } else {
                thousand += "and " + parse(h);
            }
            return thousand;
        } else if (numLen >= 7 && numLen <= 9) {
            int m = num / 1000000;
            int t = num % 1000000;

            String million = parse(m) + " million ";
            if (t >= 100) {
                million += parse(t);
            } else {
                million += "and " + parse(t);
            }
            return million;
        }

        return "error";
    }
}
