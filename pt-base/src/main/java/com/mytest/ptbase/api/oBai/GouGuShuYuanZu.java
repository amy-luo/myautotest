package com.mytest.ptbase.api.oBai;

import java.util.*;

//勾股数元组,https://renjie.blog.csdn.net/article/details/128499730
//互质，gcd法，暴力循环，排序
public class GouGuShuYuanZu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            ArrayList<int[]> list = new ArrayList<>();
            int N = in.nextInt();
            int M = in.nextInt();
            for (int i = N; i <= M/(Math.sqrt(2)); i++) {
                if (i == 1) {
                    continue;
                }
                for (int j = i + 1; j <= M; j++) {
                    if (gcd(i, j) != 1) {
                        continue;
                    }
                    double c = Math.sqrt(i * i + j * j);
                    if (c != (int) c||c>M) {
                        continue;
                    }else {
                        if (gcd(i, (int)c) == 1 && gcd(j,  (int)c) == 1) {
                            list.add(new int[]{i, j,  (int)c});
                        }
                    }
                }
            }
            if(list.size()!=0) {
                Collections.sort(list, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0]==o2[0]){
                            if(o1[1]==o2[1]){
                                return o1[2]-o2[2];
                            }
                            return o1[1]-o2[1];
                        }
                        return o1[0]-o2[0];
                    }
                });
                for (int[] o : list) {
                    System.out.println(o[0] + " " + o[1] + " " + o[2]);
                }
            }else{System.out.println("NA");}
        }

    }

    private static int gcd(int i, int j) {
        if (j == 0) {
            return i;
        }
        return gcd(j, i % j);
    }
}
