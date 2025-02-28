package com.mytest.ptbase.api.oBai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//判断一组不等式是否满足约束并输出最大差,https://renjie.blog.csdn.net/article/details/128105336
//double，过程模拟，条件判断
public class PanDuanYiZuBuDengShi {
    public static double[][] matrix;
    public static boolean[][] isVisited;
//    public static int m;
//    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] dataArray = in.nextLine().split(";");
            String[] fuhao=dataArray[dataArray.length-1].split(",");
            double[] bZhi= Arrays.stream(dataArray[dataArray.length-2].split(",")).mapToDouble(Double::parseDouble).toArray();
            double[] xZhi= Arrays.stream(dataArray[dataArray.length-3].split(",")).mapToDouble(Double::parseDouble).toArray();
            boolean res=true;
            ArrayList<Double> list = new ArrayList<>();
            matrix = new double[dataArray.length-3][xZhi.length];
            for (int i = 0; i <dataArray.length-3 ; i++) {
                matrix[i] = Arrays.stream(dataArray[i].split(",")).mapToDouble(Double::parseDouble).toArray();
                double sum=0;
                for(int j=0;j<matrix[i].length;j++){
                    sum+=matrix[i][j]*Double.valueOf(xZhi[j]);
                }
                list.add(Math.abs(sum-bZhi[i]));
                if((fuhao[i].equals("<=")&&sum-bZhi[i]>0)
                        || (fuhao[i].equals(">=")&&sum-bZhi[i]<0)
                        || (fuhao[i].equals(">")&&sum-bZhi[i]<=0)
                        || (fuhao[i].equals("<")&&sum-bZhi[i]>=0)){
                    res=false;
                }
            }
            double maxCha=Collections.max(list);
            System.out.println(res+","+(int)maxCha);
        }
    }

}
