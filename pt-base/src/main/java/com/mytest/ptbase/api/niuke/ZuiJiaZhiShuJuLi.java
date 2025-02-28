package com.mytest.ptbase.api.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//种树，最佳植树距离，https://renjie.blog.csdn.net/article/details/130648397
//二分法，枚举数的间距，将间距二分，看是否可行，看是否还有空间。坑的位置要按从小到大的位置排序。
public class ZuiJiaZhiShuJuLi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            int n = Integer.valueOf(in.nextLine());//坑
            int[] keng = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m =  Integer.valueOf(in.nextLine());//树
            Arrays.sort(keng);
            int right=(keng[n-1]-keng[0])/(m-1);//最大间距,右指针最大值
            int left=1;//左指针最小值
            int res=1;//最终结果
            while (left<=right) {
                int shangkeng = keng[0];//记录上一个坑的位置值
                int count=1;//记录满足间距时能种多少棵数
                int mid = (left + right) / 2;//二分法
                for (int i = 1; i < n; i++) {
                    if (keng[i] - shangkeng >= mid) {//当前坑减去上个种树的坑的间距
                        count++;//种了一棵满足间距的树，+1
                        shangkeng = keng[i];//将当前坑设置成下一棵树的上一个树位置。
                    }
                }
                if(count>=m){//如果满足间距种的树大于树的总数m，那么间距还有往右调整的空间。
                    res=Math.max(res,mid);
                    left=mid+1;
                }else{right=mid-1;}
            }
            System.out.println(res);
            }
        }
    }

