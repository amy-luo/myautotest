package com.mytest.ptbase.api.LTBai;

import java.util.Arrays;
import java.util.Scanner;

//最长子字符串的长度,https://renjie.blog.csdn.net/article/details/130894025
//妙不可言的前缀状态压缩，int[] position = new int[1 << 4];
public class ZuiChangZiZiFuChuanDeChangDu2 {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            s=s+s;//成环，将两个数组拼在一起
            int[] position = new int[1 << 4];
            Arrays.fill(position, -1);

            int maxLength=0;
            int status=0;//初始状态各字母为0，状态均为0
            position[0]=0;//初始状态各字母为0，状态均为0，偶数，1是奇数。字母不同的奇偶状态对应不同的位置，如果出现同样的奇偶状态对应不同的位置，说明这两个位置之间的所有字母个数肯定为偶数
            //状态0对应的起始位置是第0位置。剩下的位置是1-s.lengnth.
            for (int i = 0; i< s.length();i++) {
                if (s.charAt(i) == 'l') {status^=1<<2;}//异或运算符，相同就为0，不同为1
                if (s.charAt(i) == 'o') {status^=1<<1;}
                if (s.charAt(i) == 'x') {status^=1<<0;}//status表示从0开始到i元素，所有字母的奇偶状态
                //当两个位置的status相等时，说明这两个位置之间的所有字母都是偶数个。
                // 所以当 position[status]!=-1时，说明已被赋予坐标值，说明前面出现过同样的奇偶状态。此时无需再赋予它坐标值，而是记录下此时最大的偶数长度。
                if(position[status]>=0){
                    if((i+1- position[status])<=s.length()/2) {//子数组的长度不能超出原有未拼接的字符串s的长度。
                        maxLength = Math.max(maxLength, (i + 1) - position[status]);
                    }
                }else{
                    position[status]=i+1;//当 position[status]==-1时,说明出现新的状态，需要记录它的位置。看后面是否出现同样的状态。
                }
            }
            System.out.println(maxLength);
        }
    }
}
