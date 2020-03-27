package com.oj.river;

import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 23:19
 **/
public class BottleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();

            int count = 0;
            while (true) {
                count += num / 3;

                num = num % 3 + num / 3;
                if (num == 2) {
                    count++;
                    break;
                }
                if (num <= 1) {
                    break;
                }

            }
            System.out.println(count);
        }
        sc.close();
    }
}
