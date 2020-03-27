package com.oj.river;
import java.util.*;

public class setChar {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        Set<String> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(String.valueOf(arr[i]));
        }
        System.out.print(set.size());
        sc.close();
    }
}