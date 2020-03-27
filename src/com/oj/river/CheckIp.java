package com.oj.river;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 19:41
 **/
public class CheckIp {
    private static final String ipPattern = "^((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}$";
    private static final String maskStr = "0 128 192 224 240 248 252 254";
    private static List<String> rules = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Collections.addAll(rules, maskStr.split("\\s"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a=0,b=0,c=0,d=0,e=0;
        int pri=0,err=0;

        while (true){
            String line=br.readLine();
            String[] arr = line.split("~");
            if(arr.length!=2) break;
            String ip = arr[0];
            String mask = arr[1];
            if(checkMask(mask)){
                if(checkIp(ip)){
                    String[] ips = ip.split("\\.");
                    int iIp = Integer.parseInt(ips[0]);
                    if(iIp>=1 && iIp<=126){
                        a++;
                        if(iIp==10){
                            pri++;
                        }
                    }
                    if(iIp>=128&&iIp<=191){
                        b++;
                        if(iIp==172&&"16".equals(ips[1])){
                            pri++;
                        }
                    }
                    if(iIp>=192&&iIp<=223){
                        c++;
                        if(iIp==192&&"168".equals(ips[1])){
                            pri++;
                        }
                    }
                    if(iIp>=224&&iIp<=239){
                        d++;
                    }
                    if(iIp>=240&&iIp<=255){
                        e++;
                    }
                }else{
                    err++;
                }
            }else{
                err++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" ");
        sb.append(b).append(" ");
        sb.append(c).append(" ");
        sb.append(d).append(" ");
        sb.append(e).append(" ");
        sb.append(err).append(" ");
        sb.append(pri);
        System.out.println(sb.toString());
    }

    private static boolean checkMask(String mask){
        String[] m = mask.split("\\.");
        if("255".equals(m[0])){
            if("255".equals(m[1])){
                if("255".equals(m[2])){
                    return rules.contains(m[3]);
                }
                if(rules.contains(m[2])){
                    return "0".equals(m[3]);
                }
            }
            if(rules.contains(m[1])){
                if("0".equals(m[2])&&"0".equals(m[3])){
                    return true;
                }
            }
        }
        if(rules.contains(m[0])){
            if("0".equals(m[1])&&"0".equals(m[2])&&"0".equals(m[3])){
                return true;
            }
        }
        return false;
    }

    private static boolean checkIp(String ip){
        boolean b = Pattern.matches(ipPattern, ip);
        return b;
    }
}
