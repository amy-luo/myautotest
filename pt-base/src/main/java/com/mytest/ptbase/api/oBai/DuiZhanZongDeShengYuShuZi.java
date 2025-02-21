package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//堆栈中的剩余数字,https://renjie.blog.csdn.net/article/details/128003194
//用Stack模拟过程，还需要使用一个辅助栈Stack
public class DuiZhanZongDeShengYuShuZi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = dataArray.length;//row
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < m; i++) {
                Stack<Integer> stack2 = new Stack<>();//辅助栈
                int tmp = dataArray[i];
                stack2.push(tmp);
                int sum = 0;
                while (!stack.isEmpty()) {
                    int pop = stack.pop();
                    stack2.push(pop);
                    sum += pop;
                    if (sum == tmp) {
                        tmp = 2 * tmp;
                        sum = 0;
                        stack2.removeAllElements();
                        stack2.push(tmp);
                    } else {
                        if (sum > tmp) {
                            break;
                        }
                    }
                }
                while(!stack2.isEmpty()){
                    stack.push(stack2.pop());
                }
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
        }
    }

}
