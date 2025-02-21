package com.mytest.ptbase.api.oBai;

import java.util.Arrays;
import java.util.Scanner;

//We Are A Team,https://renjie.blog.csdn.net/article/details/130851548
//并查集，边界情况的判断要处理好。
public class WeAreATeam {
    public static int[] bingchaji;
    public static int[][] matrix;
    public static int m;
    public static int n;

    private static int find(int x) {
        if (x == bingchaji[x]) {
            return x;
        }
        return find(bingchaji[x]);
    }

    private static void merge(int x, int y) {
        x = find(bingchaji[x]);
        y = find(bingchaji[y]);
        bingchaji[y] = x;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            n = Integer.valueOf(s[0]);
            bingchaji = new int[n+1];
            for (int i = 0; i <= n; i++) {
                bingchaji[i] = i;
            }
            m = Integer.valueOf(s[1]);
            if(n<1||m<1||n>=100000||m>=100000){ System.out.println("NULL");}
            else {
                matrix = new int[m][3];
                for (int i = 0; i < m; i++) {
                    int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                    matrix[i]=dataArray;
                }
                for(int i = 0; i < m; i++){
                    int[] dataArray = matrix[i];
                    if(dataArray[0]<1||dataArray[1]<1||dataArray[0]>n||dataArray[1]>n||dataArray[2] == 2){
                        System.out.println("da pian zi");
                        continue;
                    }
                    if (dataArray[2] == 0 && find(dataArray[0]) != find(dataArray[1])) {
                        merge(dataArray[0], dataArray[1]);
                        continue;
                    }
                    if (dataArray[2] == 1) {
                        System.out.println(find(dataArray[0]) == find(dataArray[1]) ? "We are a team" : "We are not a team");
                    }
                }
            }
        }
    }
}
