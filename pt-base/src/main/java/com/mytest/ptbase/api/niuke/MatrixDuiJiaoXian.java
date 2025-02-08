package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

//矩阵对角线，对角线有正反方向，对于四个顶点和四条边要做特殊处理。
public class MatrixDuiJiaoXian {
    public ArrayList<Integer> matrix(int[][] nums){
        int m=nums.length;
        int n=nums[0].length;
        int x=0;
        int y=0;
        int pos=0;
        ArrayList<Integer> list =new ArrayList<>();
        list.add(nums[0][0]);
        while(true){
            while(x<m-1&&y>0&pos==1){
                x=x+1;
                y=y-1;
                list.add(nums[x][y]);
            }//对角线正方形
            while(x>0&&y<n-1&pos==-1){
                x=x-1;
                y=y+1;
                list.add(nums[x][y]);
            }//对角线负方向
            if(x==0&&y==0){y=y+1;pos=1;list.add(nums[x][y]);}//原点，左上顶点，需要设置对角线的转向
            if(x==0&&(y+1)<n&&pos==-1){y=y+1;pos=1;list.add(nums[x][y]);}//上面那条边，需要设置对角线的转向
            if(x==0&&(y+1)==n&&pos==-1){x=x+1;pos=1;list.add(nums[x][y]);}//右上顶点，需要设置对角线的转向
            if(y==0&&(x+1)<m&&pos==1){x=x+1;pos=-1;list.add(nums[x][y]);}//左边那条边，需要设置对角线的转向
            if(y==0&&x==m-1&&pos==1){y=y+1;pos=-1;list.add(nums[x][y]);}//左下顶点，需要设置对角线的转向
            if(y<n-1&&x==m-1&&pos==1){y=y+1;pos=-1;list.add(nums[x][y]);}//下面那条边，需要设置对角线的转向
            if(x<m-1&&y==n-1&&pos==-1){x=x+1;pos=1;list.add(nums[x][y]);}//右侧那条边，需要设置对角线的转向
            if(x==m-1&&y==n-1){break;}//右下顶点，结束，跳出循环
        }
        return list;
    }


    public static void main(String[] args){
        MatrixDuiJiaoXian z=new MatrixDuiJiaoXian();
        int[][] zu={
                { 1, 2, 3 ,8},
                { 4, 5, 6,9},
                { 7, 8, 9,5}};
        ArrayList<Integer> list =z.matrix(zu);
        System.out.println(JSONObject.toJSONString(list));
    }
}
