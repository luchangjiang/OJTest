package com.oj.river;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-11 22:26
 **/
public class TestHW {
    private static Map<String, String> mapDirection= new HashMap<>();

    public static void main(String[] args) {
        mapDirection.put("D", "R");
        mapDirection.put("R", "U");
        mapDirection.put("U", "L");
        mapDirection.put("L", "D");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");

            int num = Integer.valueOf(line[0]);
            int magic = Integer.valueOf(line[1]);

            int r = (int) (Math.sqrt(num));
            int c = r;

            int t = num - c*c;
            if (t>0) {
                r = r + 1;
            }
            int[][] dp = initData(r, c, t);
            int[][] op = initOP(r, c);

            int midR, midC;
            midR = r / 2 - 1;
            if (c % 2 == 1) {
                midC = c / 2;
            } else {
                midC = c / 2 - 1;
            }

            move(op, midR, midC, r, c, magic);

            for (int i = 0; i < r; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < c; j++) {
                    if (op[i][j] > 0) {
                        sb.append(op[i][j]).append("  ");
                    } else {
                        sb.append("00").append("  ");
                    }
                }
                System.out.println(sb.toString());
            }

            int sum = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (dp[i][j] == 0) {
                        continue;
                    }
                    sum += dp[i][j] + Math.max(0, (op[i][j] * 2 - 10));
                }
            }

            System.out.println(sum);
        }
        sc.close();
    }

    //螺旋移动算法
    private static void move(int[][] op, int midR, int midC, int r, int c, int magic){
        String direction = "D";
        int turn=0, step=0, steps = 1;
        while (magic>0) {
            operate(op, midR, midC);
            switch (direction){
                case "D":
                    midR++;
                    if(midR>r){
                        return;
                    }
                    break;
                case "R":
                    midC++;
                    if(midC>c){
                        return;
                    }
                    break;
                case "U":
                    midR--;
                    if(midR<0){
                        return;
                    }
                    break;
                case "L":
                    midC--;
                    if(midC<0){
                        return;
                    }
                    break;
                default:
                    return;
            }
            step++;
            if(step>=steps){
                direction = mapDirection.get(direction);

                turn++;
                step=0;
                if(turn==2){  //方向每转两次，步数加1
                    steps++;
                    turn=0;
                }
            }
            magic--;
        }
    }

    private static void operate(int[][]op, int midR,int midC){
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(i==0&&j==0){  //魔法师自己的位置
                    continue;
                }
                if(midR+i>=0&&midR+i<op.length&&midC+j>=0&&midC+j<op[midR+i].length){
                    op[midR+i][midC+j]+=10;
                }
            }
        }
    }

    private static int[][] initOP(int r,int c){
        int[][] op=new int[r][c];
        for(int i=0;i<c;i++){
            for(int j=0;j<c;j++){
                op[i][j] = 0;
            }
        }
        return op;
    }

    private static int[][] initData(int r, int c, int t){
        int[][] dp=new int[r][c];
        for(int i=0;i<c;i++){
            for(int j=0;j<c;j++){
                dp[i][j] = 100;
            }
        }
        if(r-c==1){
            for(int j=0;j<t;j++){
                dp[r-1][j] = 100;
            }
        }

        return dp;
    }

}
