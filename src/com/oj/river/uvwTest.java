package com.oj.river;

import java.util.*;

/**
 * @program: OJTest
 * @description: 测试路径权重影响力
 * @author: River
 * @create: 2020-03-15 09:37
 **/
public class uvwTest {
    private static int n;
    private static String[] uu,vv,ww;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            String line = sc.nextLine();

            n = Integer.parseInt(line.substring(0,line.indexOf(",")))-1;
            String data = line.substring(line.indexOf(",")+1);

            String[] arr = data.replace("],[","[").substring(1).split("[\\[\\]]");
            String u = arr[0];
            String v = arr[1];
            String w = arr[2];

            uu = u.split(",");
            if(uu.length<n){
                continue;
            }
            vv = v.split(",");
            if(vv.length<n){
                continue;
            }
            ww = w.split(",");
            if(ww.length<n){
                continue;
            }

            Map<Integer, Integer> map = getMap(n, uu, vv, ww);

            Vector<Integer> path = getPath(map);
            if(path!=null) {
                Iterator it = path.iterator();
                int maxLost = 0;
                int current = 0;
                int next = 0;
                int count = 0;
                while (it.hasNext()) {
                    if (next == 0) {
                        next = Integer.parseInt(it.next().toString());
                        continue;
                    } else {
                        current = next;
                        next = Integer.parseInt(it.next().toString());
                    }
                    count++;
                    int lost = (count * (n + 1 - count)) * getWeight(current, next);
                    maxLost = maxLost > lost ? maxLost : lost;
                }
                System.out.println(maxLost);
            }
        }
        sc.close();
    }

    private static Integer getWeight(int current, int next){
        for(int i=0;i< n;i++){
            if((current == Integer.parseInt(uu[i])&&next == Integer.parseInt(vv[i]))||
                    (next == Integer.parseInt(uu[i])&&current == Integer.parseInt(vv[i]))){
                return Integer.parseInt(ww[i]);
            }
        }
        return 0;
    }

    private static Map<Integer, Integer> getMap(int n, String[] uu, String[] vv, String[] ww){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int uuu = Integer.parseInt(uu[i]);
            int vvv = Integer.parseInt(vv[i]);
            int www = Integer.parseInt(ww[i]);
            if(map.containsKey(uuu)){
                map.put(uuu, map.get(uuu)+1);
            }else{
                map.put(uuu,1);
            }
            if(map.containsKey(vvv)){
                map.put(vvv, map.get(vvv)+1);
            }else{
                map.put(vvv,1);
            }
        }
        return map;
    }

    private static Vector<Integer> getPath(Map<Integer, Integer> map){
        Integer current = 0;
        List<Integer> list = new ArrayList<>();
        Vector<Integer> path = new Vector<>();
        for(Map.Entry entry : map.entrySet()){
            if(1==Integer.parseInt(entry.getValue().toString())){
                current = Integer.parseInt(entry.getKey().toString());
                path.add(current);
                break;
            }
        }
        if(current==0){
            return null;
        }

        int lp = n;
        while (true){
            for(int i=0;i<n;i++){
                if(!list.contains(i)) {
                    if (current == Integer.parseInt(uu[i])) {
                        current = Integer.parseInt(vv[i]);
                        path.add(current);
                        list.add(i);
                        break;
                    } else if (current == Integer.parseInt(vv[i])) {
                        current = Integer.parseInt(uu[i]);
                        path.add(current);
                        list.add(i);
                        break;
                    }
                }
            }
            if(path.size()>n){
                break;
            }
            lp--;
            if(lp<0){
                break;
            }
        }

        return path;
    }
}
