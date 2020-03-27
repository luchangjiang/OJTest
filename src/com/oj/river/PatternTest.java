package com.oj.river;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-07 17:28
 **/
public class PatternTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = "[ADWS][0-9]{1,2}";

        String[] points = sc.next().split(";");
        ArrayList<String> pointList = new ArrayList<>();
        Collections.addAll(pointList, points);
        for(int i=pointList.size()-1;i>=0;i--){
            if(!Pattern.matches(pattern, pointList.get(i))){
                pointList.remove(i);
            }
        }
        Point pt = new Point(0,0);
        for(int i=0;i<pointList.size();i++) {
            String p = pointList.get(i);
            move(pt, p);
        }
        System.out.println(pt.x + "," + pt.y);
        sc.close();
    }

    private static void move(Point pt, String p){
        String direction = p.substring(0,1);
        int dis = Integer.valueOf(p.substring(1));

        switch (direction){
            case "A":
                pt.x -= dis;
                break;
            case "D":
                pt.x += dis;
                break;
            case "W":
                pt.y += dis;
                break;
            case "S":
                pt.y -=dis;
                break;
        }
    }

}
