package com.mytest.ptbase.api.niuke;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

//数字排列，全排列，https://renjie.blog.csdn.net/article/details/130894272
//屏幕给出 1 ~ 9 中任意 4 个不重复的数字，大家以最快时间给出这几个数字可拼成的数字从小到大排列位于第 N 位置的数字，其中 N 为给出数字中最大的（如果不到这么多数字则给出最后一个即可）。
//1,4,8,7
//        2 可以当作 5 来使用，5 也可以当作 2 来使用进行数字拼接，且屏幕不能同时给出 2 和 5；
//        6 可以当作 9 来使用，9 也可以当作 6 来使用进行数字拼接，且屏幕不能同时给出 6 和 9。
//        那么第 N （即8）个的数字为 41。
public class ShuZiPaiLieQuanPaiLie {
    public static int[] firstHang;
    public static boolean[] isVisited;
    public static int m;
    public static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            String s=in.nextLine();
            Integer num=0;
            if((s.contains("2")&&s.contains("5"))||(s.contains("6")&&s.contains("9"))){
                num=-1;
            }

            try {
                firstHang = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
            }catch (Exception e){
                num=-1;
            }
            m = firstHang.length;//row
            isVisited=new boolean[m];
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < m; i++) {
                if(firstHang[i]<0){
                    num=-1;
                    break;
                }
                map.put(firstHang[i],map.getOrDefault(firstHang[i],0)+1);
                if(map.get(firstHang[i])>=2){num=-1;break;}
//                int length=s.replaceAll(String.valueOf(firstHang[i]),"").length();
//                if(s.length()-length>1){
//                    num=-1;
//                break;}
            }
            if(num!=-1){
            Arrays.sort(firstHang);
            list = new ArrayList<>();
            StringBuilder stb = new StringBuilder();
            quanpailie(0,stb);
            Collections.sort(list);
            System.out.println(JSONObject.toJSONString(list));
            if(firstHang[m-1]<=list.size()) {
                num = list.get(firstHang[m - 1] - 1);
            }else{num=list.get(list.size()-1);}
            }
            System.out.println(num);


        }
    }
    private static void quanpailie(int row,StringBuilder stb){
        if(stb.length()!=0) {
            list.add(Integer.valueOf(stb.toString()));//因为是全排列，中间过程中的字符拼接也要加入list
        }
        if(row==m){
            return;
        }
        for(int i=0;i<m;i++){
            if(!isVisited[i]){
                stb.append(firstHang[i]);
                isVisited[i]=true;
                quanpailie(row+1,stb);
                stb.deleteCharAt(stb.length()-1);
                isVisited[i]=false;
                if(firstHang[i]==2){
                    stb.append("5");
                    isVisited[i]=true;
                    quanpailie(row+1,stb);
                    stb.deleteCharAt(stb.length()-1);
                    isVisited[i]=false;
                }
                if(firstHang[i]==5){
                    stb.append("2");
                    isVisited[i]=true;
                    quanpailie(row+1,stb);
                    stb.deleteCharAt(stb.length()-1);
                    isVisited[i]=false;
                }
                if(firstHang[i]==6){
                    stb.append("9");
                    isVisited[i]=true;
                    quanpailie(row+1,stb);
                    stb.deleteCharAt(stb.length()-1);
                    isVisited[i]=false;
                }
                if(firstHang[i]==9){
                    stb.append("6");
                    isVisited[i]=true;
                    quanpailie(row+1,stb);
                    stb.deleteCharAt(stb.length()-1);
                    isVisited[i]=false;
                }
            }
//            else{
//                quanpailie(row+1,stb);
//            }
        }
    }
}
