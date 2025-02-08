package com.mytest.ptbase.api.niuke;
import java.util.*;

public class CuowuRizhiJilu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        ArrayList<String[]> list=new ArrayList<>();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b=a.split(" ")[0];
            String c=a.split(" ")[1];//行号
            String[] d=b.split("\\\\");
            // System.out.println(d[0]+" "+d[1]);
            String e=d[d.length-1];
            String f=e;
            if(e.length()>16){
                f=e.substring(e.length()-16);//文件名后16位
            }
            // System.out.println(f+" "+c);
            String[] zu={f,c,"1"};
            int count=0;
            for(String[] o:list){
                if((o[0]+o[1]).equals(f+c)){
                    o[2]=String.valueOf(Integer.valueOf(o[2])+1);
                }else{
                    count++;
                }
            }
            if(count==list.size()){
                list.add(zu);
            }

        }
        if(list.size()<=8){
            for(String[] o:list){
                System.out.println(o[0]+" "+o[1]+" "+o[2]);
            }
        }
        if(list.size()>8){
            for(int i=list.size()-8;i<list.size();i++){
                System.out.println(list.get(i)[0]+" "+list.get(i)[1]+" "+list.get(i)[2]);
            }
        }
    }
}
