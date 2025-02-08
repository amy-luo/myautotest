package com.mytest.ptbase.api.niuke;

import java.util.*;

//跳格子2，https://fcqian.blog.csdn.net/article/details/130764202?spm=1001.2014.3001.5502
public class TiaoGeZi2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int[] geZi = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m=geZi.length;
            int count = m % 2 == 0 ? m / 2 : (m - 1) / 2;
            if (m == 1) {
                count = 1;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int sum = 0;
                for (int j = 0; j < count; j++) {
                    int index = i + 2 * j;
                    if (index >= m) {
                        index = index - m;
                    }
                    sum += geZi[index];
                }
                list.add(sum);
            }
            System.out.println(Collections.max(list));
        }

    }
}
