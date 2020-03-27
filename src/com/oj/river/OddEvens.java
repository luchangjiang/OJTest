package com.oj.river;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-08 16:19
 **/
import java.util.*;
public class OddEvens {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = Integer.valueOf(sc.nextLine());
            String[] data = sc.nextLine().split(" ");

            List<Long> odds = new ArrayList<>();
            List<Long> evens = new ArrayList<>();
            for(int i=0;i<n;i++){
                long p = Long.valueOf(data[i]);
                if(p % 2 == 0){
                    odds.add(p);
                }else{
                    evens.add(p);
                }
            }

            long[] evensMatch = new long[evens.size()];
            int result = 0;
            for(int i=0;i<odds.size();i++){
                int[] used = new int[evens.size()];
                if(find(odds.get(i),evens,used,evensMatch)){
                    result++;
                }
            }
            System.out.println(result);
        }

        sc.close();
    }

    private static boolean find(long x, List<Long> evens, int[] used, long[] evensMatch){
        for(int j=0;j<evens.size();j++){
            if(isPrime(x+evens.get(j))&&used[j]==0){
                used[j]=1;
                if(evensMatch[j]==0||find(evensMatch[j],evens,used,evensMatch)){
                    evensMatch[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(long sum){
        for(int i=2;i<=Math.sqrt(sum);i++){
            if(sum % i == 0){
                return false;
            }
        }
        return true;
    }
}
