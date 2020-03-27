package com.oj.river;

import java.util.*;
public class IpConvert {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String ip = sc.nextLine();
            long num = Long.parseLong(sc.nextLine());
            System.out.println(ip2Ten(ip));
            System.out.println(ten2Ip(num));
        }
        sc.close();
    }

    private static long ip2Ten(String ip){
        String[] arr = ip.split("\\.");

        long n= 0;
        for(int i=0;i<arr.length;i++){
            n = n<<8;
            n += Long.parseLong(arr[i]);
        }
        return n;
    }

    private static String ten2Ip(long num){
        String ip = Long.toBinaryString(num);

        StringBuilder sb=new StringBuilder();
        if(ip.length()<32){
            for(int i=0;i<(32-ip.length());i++){
                sb.append("0");
            }
        }
        sb.append(ip);

        String sbs = sb.toString();
        String result = "";
        for(int i=0;i<4;i++){
            String temp = sbs.substring(i*8,(i+1)*8);
            result += Integer.parseInt(temp,2) + ".";
        }
        return result.substring(0,result.length()-1);
    }
}