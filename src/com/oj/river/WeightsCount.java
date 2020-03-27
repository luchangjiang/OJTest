package com.oj.river;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-22 09:31
 **/
public class WeightsCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            String[] weightA = sc.nextLine().split(" ");
            String[] numA = sc.nextLine().split(" ");
            int[] weight = new int[n];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(weightA[i]);
                nums[i] = Integer.parseInt(numA[i]);
            }

            Set<Integer> wSet = new HashSet<>();
            int count = fama(n, 0, weight, nums, wSet);
            System.out.println(count);
        }
        sc.close();
    }

    private static int fama(int n, int index, int[] weight, int[] nums, Set<Integer> wSet) {
        if (index + 1 < n) {
            fama(n, index + 1, weight, nums, wSet);
            Set<Integer> set = new HashSet<>();
            for (int s : wSet) {
                int w = 0;
                for (int j = 0; j <= nums[index]; j++) {
                    w = weight[index] * j + s;
                    set.add(w);
                }
            }
            wSet.addAll(set);
        } else {
            int w = 0;
            for (int j = 0; j <= nums[index]; j++) {
                w = weight[index] * j;
                wSet.add(w);
            }
        }

        return wSet.size();
    }
}
