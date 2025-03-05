package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

// 精准核酸检测，https://renjie.blog.csdn.net/article/details/135179714
//并查集
public class JingZhunHeSuanJianCe {
    public static int[][] matrix;
    public static int[] bingchaji;

    private static int find(int x) {
        return bingchaji[x] == x ? x : find(bingchaji[x]);
    }

    private static void merge(int x, int y) {
        int new_x = find(x);
        int new_y = find(y);
        bingchaji[new_y] = new_x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int m = Integer.valueOf(in.nextLine());
            bingchaji = new int[m];
            for (int i = 0; i < m; i++) {
                bingchaji[i] = i;
            }
            int[] ganran = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            matrix = new int[m][m];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = dataArray[j];
                    if (matrix[i][j] == 1 && i != j && find(i) != find(j)) {
                        merge(i, j);
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < bingchaji.length; i++) {
                for (int o : ganran) {
                    if (find(bingchaji[i]) == find(o)) {//根节点与易感染人员根节点相同就是需要做核酸的人
                        count++;
                        break;
                    }
                }
            }
            StringBuilder stb = new StringBuilder();
            System.out.println(count - ganran.length);//减去输入的已确诊感染的人数
        }
    }

}
