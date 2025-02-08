package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MatrixShunShiZhen {

    public List<Integer> spiralOrder(int[][] nums) {
        int m=nums.length;
        int n=nums[0].length;
        int x=0;
        int y=0;
        List<Integer> list =new ArrayList<>();//存放移动的坐标数组[x,y]
        int xunhuan=0;
        if(Math.min(m,n)%2==0){xunhuan=Math.min(m,n)/2;}
        if(Math.min(m,n)%2==1){xunhuan=Math.min(m,n)/2+1;}
//        System.out.println(xunhuan);
        for(int i=0;i<xunhuan;i++){
            int count=2*((m-2*i)+(n-2*i))-4;
            if(m-2*i==1&&n-2*i>0){count=n-2*i;}
            if(n-2*i==1&&m-2*i>0){count=m-2*i;}
            if(m-2*i==0||n-2*i==0){count=0;}
            int j=0;
            System.out.println("x: "+x+" y: "+y);
            if(x<m&&y<n&&count!=0){
                list.add(nums[x][y]);
                System.out.println(nums[x][y]);}
//               顺时针，右下左上；
            while(j<count-1){
                if(n==1){if(x<m&&y==i){x=x+1;list.add(nums[x][y]);j++;continue;}}
                if(x>=i&&x<m-1-i&&y==n-1-i){x=x+1;list.add(nums[x][y]);System.out.println(nums[x][y]);j++;continue;}//右边那条边，坐标往下移动，同时为左右边时，优先走右条边算法
                else if(y==i&&x<=m-1-i&&x>i){x=x-1;list.add(nums[x][y]);System.out.println(nums[x][y]);j++;continue;}//左边那条边，坐标往上移动
                else if(x==i&&y>=i&&y<n-1-i){y=y+1;list.add(nums[x][y]);System.out.println(nums[x][y]);j++;continue;}//上面一条边，坐标往右移动，同时为上下边时，优先走上条边算法
                else if(y>i&&y<=n-1-i&&x==m-1-i){y=y-1;list.add(nums[x][y]);System.out.println(nums[x][y]);j++;continue;}//下面那条边，坐标往左移动

//                    System.out.println("次数  "+j);
            }
            y = y + 1;
        }
        return list;
    }

    //方法二，更简洁。存储顺时针的方向，遇到边界值时，按顺时针方向的顺改变方向。并且记录元素是否被走过。
    public List<Integer> spiralOrder2(int[][] nums) {
        int m=nums.length;
        int n=nums[0].length;
        int x=0;
        int y=0;
        List<Integer> list =new ArrayList<>();//存放移动的坐标数组[x,y]
        if(nums==null||nums.length==0||nums[0].length==0){
            return list;
        }
        boolean[][] isExist=new boolean[m][n];
        int[][] direct=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};//移动顺序，右下左上；
        int directIndex=0;
        for(int i=0;i<m*n;i++){
            list.add(nums[x][y]);
            isExist[x][y]=true;
            int nextX=x+direct[directIndex][0];
            int nextY=y+direct[directIndex][1];
            if(nextX<0||nextX>=m||nextY<0||nextY>=n||isExist[nextX][nextY]){
                directIndex=(directIndex+1)%4;
            }
            x+=direct[directIndex][0];
            y+=direct[directIndex][1];
        }
        return list;
    }



    public static void main(String[] args){
        MatrixShunShiZhen z=new MatrixShunShiZhen();
        int[][] zu={
                { 1, 2, 3 ,7, 8, 9},
                { 4, 5, 6,7, 8, 9},
                { 7, 8, 9,7, 8, 9}
        };
        List<Integer> list =z.spiralOrder2(zu);
        System.out.println(JSONObject.toJSONString(list));
    }

}
