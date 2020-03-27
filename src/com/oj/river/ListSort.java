package com.oj.river;
import java.util.*;

public class ListSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(sc.next());
        }
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
        sc.close();
    }
}