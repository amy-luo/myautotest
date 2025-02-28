package com.mytest.ptbase.api.LTBai;

import java.util.*;

//Linux发行版的数量,https://renjie.blog.csdn.net/article/details/128719333
//并查集
public class LinuxFaXingBanDeShuLiang {
    public static int[][] matrix;
    public static int[] bingchaji;
    public static boolean[][] isVisited;
    public static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s=in.nextLine();
            m = Integer.valueOf(s);
            bingchaji = new int[m];
            for(int i=0;i<m;i++){
                bingchaji[i]=i;
            }
            matrix=new int[m][m];
            isVisited=new boolean[m][m];
            for (int i = 0; i < m; i++) {
                int[] dataArray = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < m; j++) {
                    matrix[i][j]=dataArray[j];
                    if(matrix[i][j]==1){
                        if(i!=j&&find(i)!=find(j)) {
                            merge(i, j);
                        }
                    }
                }
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int o:bingchaji){
                map.put(o, map.getOrDefault(o, 0) + 1);
            }
            ArrayList<Integer> list=new ArrayList<Integer>(map.values());
            Collections.sort(list,((o1, o2) -> o2-o1));
            System.out.println(list.get(0));
        }
    }
    private static void merge(int x,int y){
        int new_x=find(bingchaji[x]);
        int new_y = find(bingchaji[y]);
        bingchaji[new_y]=new_x;
    }

    private static int find(int x){
        if(bingchaji[x]==x){return x;}
        else{
            return find(bingchaji[x]);
        }

    }

}
