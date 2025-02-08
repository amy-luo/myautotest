package com.mytest.ptbase.api.niuke;
import java.util.*;

public class NiXvBuChongFu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        while (in.hasNextLine()) { // 注意 while 处理多个 case
            ArrayList<String> list=new ArrayList<>();
            String[] a = in.nextLine().split("");
            String[] b=new String[a.length];
            if(a[a.length-1]!="0"){
                for(int i=0;i<a.length;i++){
                    b[i]=a[a.length-i-1];
                    if(!list.contains(b[i])){
                        list.add(b[i]);
                    }
                }
            }
            StringBuilder stringBuilder=new StringBuilder();
            for(String o:list){
                stringBuilder.append(o);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
