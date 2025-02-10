package com.mytest.ptbase.api.niuke;

import java.util.*;

//书籍叠放,动态规划，有特点，不一样的一维动态规划，需要再看看。https://renjie.blog.csdn.net/article/details/127972761
//书籍的长、宽都是整数对应 (l,w)。如果书A的长宽度都比B长宽大时，则允许将B排列放在A上面。现在有一组规格的书籍，书籍叠放时要求书籍不能做旋转，请计算最多能有多少个规格书籍能叠放在一起。
public class ShuJiDieFang {
    public static int[][] matrix;
    public static boolean[][] isVisited;

    //    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            String[] s = in.nextLine().replaceAll("\\[", "").replaceAll("\\]", "").split(",");
            int[] data = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
            int m = data.length / 2;
            matrix = new int[m][2];
            for (int i = 0; i < m; i++) {
                matrix[i][0] = data[2 * i];
                matrix[i][1] = data[2 * i + 1];
            }
            Arrays.sort(matrix, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            System.out.println(dongTaiGuiHua(m));
        }
    }

    private static int dongTaiGuiHua(int m) {
        int[] dp = new int[m + 1];
        dp[0] = 0;
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (matrix[i - 1][0] > matrix[j - 1][0] && matrix[i - 1][1] > matrix[j - 1][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
