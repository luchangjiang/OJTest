package com.oj.river;

import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-21 22:07
 **/
public class NetSegment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] ips = sc.nextLine().split(" ");
            String mask = ips[0];
            String ip1 = ips[1];
            String ip2 = ips[2];

            int res = checkNetSegment(mask, ip1, ip2);
            System.out.println(res);
        }
        sc.close();
    }
    /*
     * 功能: 判断两台计算机IP地址是同一子网络。
     * 输入参数：    String Mask: 子网掩码，格式：“255.255.255.0”；
     *               String ip1: 计算机1的IP地址，格式：“192.168.0.254”；
     *               String ip2: 计算机2的IP地址，格式：“192.168.0.1”；
     *

     * 返回值：      0：IP1与IP2属于同一子网络；     1：IP地址或子网掩码格式非法；    2：IP1与IP2不属于同一子网络
     */
    private static int checkNetSegment(String mask, String ip1, String ip2)
    {
        /*在这里实现功能*/
        char[] charMask = toBinaryIp(mask).toCharArray();
        char[] charIp1 = toBinaryIp(ip1).toCharArray();
        char[] charIp2 = toBinaryIp(ip2).toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<charMask.length;i++){
            Integer t1 = charMask[i] & charIp1[i] - '0';
            Integer t2 = charMask[i] & charIp2[i] - '0';
            sb1.append(t1.toString());
            sb2.append(t2.toString());
        }

        String ipA = binary2Ip(sb1.toString());
        String ipB = binary2Ip(sb2.toString());
        System.out.println(ipA + " ~ " + ipB);
        return sb1.toString().equals(sb2.toString())?1:0;

    }

    private static String binary2Ip(String bin){
        String ip="";
        for(int i=0;i<4;i++){
            String tmp = bin.substring(i*8,(i+1)*8);
            int a = Integer.parseInt(tmp, 2);
            ip +=a;
            if(i<3){
                ip +=".";
            }
        }
        return ip;
    }

    private static String toBinaryIp(String ip){
        String[] ips = ip.split("\\.");

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ips.length;i++){
            String tmp = "00000000" + Integer.toBinaryString(Integer.parseInt(ips[i]));
            tmp = tmp.substring(tmp.length()-8);
            sb.append(tmp);

        }

        return sb.toString().trim();
    }

}
