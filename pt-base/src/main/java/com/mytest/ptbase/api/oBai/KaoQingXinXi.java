package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//考勤信息，https://renjie.blog.csdn.net/article/details/130852745
//滑动窗口，双指针，遍历
public class KaoQingXinXi {
    public static int[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        while (in.hasNextLine()) {
            int m=Integer.valueOf(in.nextLine());
            ArrayList<String[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] s = in.nextLine().split(" ");
                list.add(s);
            }
            for(String[] kaoqin:list) {
                int queqin=0;
                int chitui=0;
                boolean res=true;
                for (int i = 0,j=0; i <kaoqin.length&&j<kaoqin.length;){
                    if(kaoqin[j].equals("absent")){
                        queqin++;
                        if(queqin>=2){res=false;break;}
                    }
                    if(j>0&&(kaoqin[j].equals("late")||kaoqin[j].equals("leaveearly"))
                            &&(kaoqin[j-1].equals("late")||kaoqin[j-1].equals("leaveearly"))){
                        res=false;break;
                    }
                    if(kaoqin[j].equals("late")||kaoqin[j].equals("leaveearly")){
                        chitui++;
                        if(chitui>=3){res=false;break;}
                    }
                    if(j-i>=6){
                        if(kaoqin[i].equals("late")||kaoqin[i].equals("leaveearly")){
                            chitui--;
                        }
                        i++;
                    }
                    j++;
                }
                System.out.println(res);
            }
        }
    }
}
