package com.mytest.ptbase.api.niuke;

import java.util.Scanner;
import java.util.*;

//矩阵匹配,二分图，https://renjie.blog.csdn.net/article/details/136305258
public class JvZhenPiPeiErFenTu {
    public static int V = 0;
    public static int[] match = new int[1000];
    public static int n = 0;
    public static int m = 0;
    public static int k = 0;
    public static int[][] a = new int[1000][1000];
    public static ArrayList<ArrayList<Integer>> Graph = new ArrayList<>();
    public static int[] used = new int[1000];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 1000; i++) {
            ArrayList<Integer> row1 = new ArrayList<>();
            Graph.add(row1);
        }

        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                a[i][j] = in.nextInt();
        }
        int l = 1, r = 1000000000, ans = r;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);

    }

    public int[] split(String input_str) {
        String[] tmp2 = input_str.split(" ");
        int[] nums = new int[tmp2.length];
        for (int i = 0; i < tmp2.length; i++) {
            nums[i] = Integer.parseInt(tmp2[i]);
        }
        return nums;
    }

    public static void add_edge(int u, int v) {
        Graph.get(u).add(v);
        Graph.get(v).add(u);
    }

    public static int dfs(int v) {
        used[v] = 1;
        for (int i = 0; i < Graph.get(v).size(); i++) {
            int u = Graph.get(v).get(i), w = match[u];
            if (w < 0 || (used[w] == 0) && dfs(w) == 1) {
                match[v] = u;
                match[u] = v;
                return 1;
            }
        }
        return 0;
    }

    public static int bipartite_matching() {
        int res = 0;
        for (int i = 0; i < match.length; i++) {
            match[i] = -1;
        }
        for (int v = 0; v < V; v++) {
            if (match[v] < 0) {
                for (int i = 0; i < used.length; i++) {
                    used[i] = 0;
                }
                if (dfs(v) == 1) res++;
            }
        }
        return res;
    }


    public static boolean check(int x) {
        V = n + m + 1;
        for (int i = 0; i < V; i++) {
            Graph.get(i).clear();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                if (a[i][j] <= x) {
                    add_edge(i, n + j);
                }
        }
        return bipartite_matching() >= n - k + 1;
    }

}
