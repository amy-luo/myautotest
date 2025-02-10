package com.mytest.ptbase.api.niuke;

import java.util.*;

//跳格子2，https://fcqian.blog.csdn.net/article/details/130764202?spm=1001.2014.3001.5502
//题目描述
//        小明和朋友玩跳格子游戏，有 n 个连续格子组成的圆圈，每个格子有不同的分数，小朋友可以选择以任意格子起跳，但是不能跳连续的格子，不能回头跳，也不能超过一圈;
//
//        给定一个代表每个格子得分的非负整数数组，计算能够得到的最高分数。
//
//        输入描述
//        给定一个数例，第一个格子和最后一个格子首尾相连，如: 2 3 2
//
//        输出描述
//        输出能够得到的最高分，如: 3
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
            ArrayList<Integer> list = new ArrayList<>();//存放不同跳法的得分
            for (int i = 0; i < m; i++) {//从第几个开始跳
                int sum = 0;
                for (int j = 0; j < count; j++) {//跳多少次
                    int index = i + 2 * j;//每次跳到的索引，知道初始索引位置
                    if (index >= m) {//如果索引超出数组长度，就从头开始。
                        index = index - m;
                    }
                    sum += geZi[index];
                }
                list.add(sum);
            }
            System.out.println(Collections.max(list));//输出最大得分
        }

    }
}
