package com.oj.river;

import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-22 13:13
 **/
public class FillRect {
    private static int nilCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[][] ds = new String[9][9];
            int[][] dp = new int[9][9];

            nilCount = 0;
            for (int i = 0; i < ds.length; i++) {
                ds[i] = sc.nextLine().split(" ");
                for (int k = 0; k < ds[i].length; k++) {
                    dp[i][k] = Integer.parseInt(ds[i][k]);
                    if (dp[i][k] == 0) {
                        nilCount++;
                    }
                }
            }
            int count = 0;
            while (nilCount > 0) {
                fill(dp);
                count++;
                if (count >= 1000) {
                    break;
                }
            }
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    if(j==8){
                        System.out.print(dp[i][j]+"\n");
                    }else{
                        System.out.print(dp[i][j] + " ");
                    }
                }
            }
        }
        sc.close();
    }

    private static void fill(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            int[] b = new int[dp[i].length];
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] == 0) {
                    fillNum(dp, i, j);
                }
            }
        }
    }

    private static boolean fillNum(int[][] dp, int m, int n) {
        int k = -1;
        String nums = "123456789";
        for (int t = 0; t < dp[m].length; t++) {
            if (dp[m][t] == 0) {
                k = t;
            } else {
                nums = nums.replace(String.valueOf(dp[m][t]), "");
            }
        }
        if (nums.length() == 1) {
            dp[m][k] = Integer.parseInt(nums);
            nilCount--;
            return true;
        }

        nums = "123456789";
        for (int t = 0; t < dp.length; t++) {
            if (dp[t][n] == 0) {
                k = t;
            } else {
                nums = nums.replace(String.valueOf(dp[t][n]), "");
            }
        }
        if (nums.length() == 1) {
            dp[k][n] = Integer.parseInt(nums);
            nilCount--;
            return true;
        }
        return false;
    }
}
