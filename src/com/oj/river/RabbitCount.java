package com.oj.river;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-20 21:13
 **/
public class RabbitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int monthCount = sc.nextInt();
            int total = getTotalCount(monthCount);
            System.out.println(total);

            int total2 = getTotalCount2(monthCount);
            System.out.println(total2);
        }
        sc.close();
    }

    private static int getTotalCount(int monthCount) {
        ArrayList<Point> rabbits = new ArrayList<Point>();
        rabbits.add(new Point(1, 1));
        for (int i = 0; i < monthCount; i++) {
            for (int j = 0; j < rabbits.size(); j++) {
                rabbits.get(j).x++;
                if (rabbits.get(j).x > 3) {
                    rabbits.add(new Point(1, 1));
                }
            }
        }

        return rabbits.size();
    }

    private static int getTotalCount2(int m) {
        int a = 1, b = 0, c = 0;
        while (m > 1) {
            c += b;
            b = a;
            a = c;
            m--;
        }
        return a + b + c;
    }
}
