package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;

//不含101的数,https://fcqian.blog.csdn.net/article/details/128065744
//将字符递归，https://blog.csdn.net/weixin_44502509/article/details/130209988
public class BuHan101DeShu {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s=in.nextLine().split(" ");
            int left=Integer.valueOf(s[0]);
            int right=Integer.valueOf(s[1]);
            String start =Long.toBinaryString(left-1);//减去left
            String end = Long.toBinaryString(right);
            int count=0;
            int count1=0;
            int count2=0;
//            count = get(left, right);
           count1= dfs(end.toCharArray(), 0, 0, 0, true);
           count2= dfs(start.toCharArray(), 0, 0, 0, true);
//            System.out.println(count);
            System.out.println(count1-count2);
        }
    }
    private static int get(int left,int right){
        int count=0;
        for (int i = left; i <=right; i++) {
            if(!Long.toBinaryString(i).contains("101")){
                count++;
            }
        }
        return count;
    }
    public static int dfs(char[] arr, int cur, int pre, int prePre,boolean flag){
        if (cur == arr.length){
            // 遍历到末尾返回1
            return 1;
        }
        // flag的含义是指当前字符是否受限,比如 1010 现在来到最后一位 0 如果当前位置受限(前两位为01)只能为0,如果为1 则 1011可能会超出范围
        int curRange = flag? arr[cur] - '0' : 1;
        int res = 0;
        for (int i = 0; i <= curRange; i++) {
            if (prePre == 1 && pre == 0 && i == 1){
                // 出现101
                continue;
            }
            // 如果前面两个位置都受限制则下一个位置必然受限
            res += dfs(arr, cur+ 1,i,pre, flag&& i == curRange);
        }
        return res;
    }
}
