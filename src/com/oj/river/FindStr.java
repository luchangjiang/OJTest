package com.oj.river;

/**
 * @program: OJTest
 * @description:
 * @author: River
 * @create: 2020-03-08 11:02
 **/

import java.util.*;
public class FindStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int n = Integer.parseInt(input[0]);
            String findStr = input[input.length-2];
            Set<String> set = new HashSet<>();
            SortedMap<String, String> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                if(i<input.length-3) {
                    if(input[i+1].length()>=findStr.length()) {
                        String k = String.valueOf(input[i + 1]);
                        char[] v = k.toCharArray();
                        k=k + "-" + i;
                        Arrays.sort(v);
                        map.put(k, String.valueOf(v));
                    }
                }
            }


            int maxFind = Integer.parseInt(input[input.length-1]);
            int findCount = 0, printCount = 0;
            char[] ff = findStr.toCharArray();
            Arrays.sort(ff);

            String findStr2 = String.valueOf(ff);
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                String key = entry.getKey().toString();
                key = key.substring(0, key.indexOf("-"));
                String value = entry.getValue().toString();
                if (!key.equals(findStr)) {
                    if (value.indexOf(findStr2) >= 0) {
                        if (printCount < maxFind) {
                            sb.append(key).append(" ");
                            printCount++;
                        }
                        findCount++;
                    }
                }
            }
            System.out.println(findCount + " " + sb.toString());

        }
        sc.close();
    }
}
