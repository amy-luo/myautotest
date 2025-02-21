package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//木板，最短木板长度,https://renjie.blog.csdn.net/article/details/128266061
//优先队列，默认从小到达排序
public class MuBan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int m = Integer.valueOf(s[0]);
            int n = Integer.valueOf(s[1]);
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int o:dataArray){
                queue.add(o);}
            while (n > 0) {
                queue.add(queue.poll()+1);
                n--;
            }
            System.out.println(queue.peek());
        }
    }

}
