package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//仿 LISP 运算,https://renjie.blog.csdn.net/article/details/127972933
//用stack存放操作步骤和数字，遇到)触发计算
public class FangLISPjiSuan {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().replaceAll("\\(", "( ").replaceAll("\\)", " )").split(" ");
            int m = s.length;
            Stack<String> stack = new Stack<>();
            String res = "";
            for (int i = 0; i < m; i++) {
                switch (s[i]) {
                    case "(":
                        continue;
                    case ")":
                        if (stack.isEmpty()) {
                            res = "error";
                            break;
                        } else {
                            int tmp2 = Integer.valueOf(stack.pop());
                            int tmp1 = Integer.valueOf(stack.pop());
                            String type = stack.pop();
                            if(type.equals("div")&&tmp2==0){
                                res = "error";
                                break;}
                            int count = cal(tmp1, tmp2, type);
                            stack.push(String.valueOf(count));
                            break;
                        }
                    default:
                        stack.push(s[i]);
                }
                if(res.equals("error")){break;}
            }
            if (res.equals("")) {
                System.out.println(stack.pop());
            } else {
                System.out.println(res);
            }
        }
    }

    private static int cal(int tmp1, int tmp2, String type) {
        switch (type) {
            case "add":
                return tmp1 + tmp2;
            case "sub":
                return tmp1 - tmp2;
            case "mul":
                return tmp1 * tmp2;
            case "div":
                double fan=(double)tmp1/(double)tmp2;
                if(fan<0&&fan!=(int) fan){fan--;}
                return (int)fan;
        }
        return 0;

    }
}
