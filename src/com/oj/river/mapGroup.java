package com.oj.river;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 13:21
 **/
public class mapGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new HashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            String[] arr = line.split("\\s+");
            if(arr.length!=2) return;

            int key = Integer.parseInt(arr[0]);
            int value = Integer.parseInt(arr[1]);
            if(!map.containsKey(key)) {
                map.put(key,value);
            }
            else{
                int m = map.get(key)+value;
                map.put(key, m);
            }
        }

        for(Map.Entry item: map.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }

        sc.close();
    }
}
