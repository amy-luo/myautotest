package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//堆栈中的剩余数字,https://renjie.blog.csdn.net/article/details/128003194
//用Stack模拟过程，还需要使用一个辅助栈Stack
public class JiSuanDuiZhanZongDeShengYuShuZi {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = dataArray.length;//row
            Stack<Integer> stack = new Stack<>();//主栈
            for (int i = 0; i < m; i++) {
                Stack<Integer> stack2 = new Stack<>();//辅助栈
                int tmp = dataArray[i];
                stack2.push(tmp);//将当前元素存入辅助栈，不直接放入主栈，因为需要拿主栈中的元素来进行比较。
                int sum = 0;
                while (!stack.isEmpty()) {
                    int pop = stack.pop();//将主栈中的元素拿出来，取和
                    stack2.push(pop);//主栈中的元素拿出来后要放入辅助栈中，方便恢复。
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
                while(!stack2.isEmpty()){//恢复主栈中pop到辅助栈中的元素
                    stack.push(stack2.pop());
                }
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
        }
    }

}
