package com.mytest.ptbase.api.niuke;
import java.util.*;

public class ZuoBiaoMove {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int x=0;
        int y=0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] a = in.nextLine().split(";");

            for(String o:a){
                if(o!=""&&o.length()>=2){
                    String b=o.substring(0,1);
                    boolean flag=true;
                    for(int i=0;i<o.substring(1).length();i++){
                        if(Character.isDigit(o.substring(1).charAt(i))==false){
                            flag=false;
                        }
                    }
                    if(flag){
                        Integer c=Integer.valueOf(o.substring(1));
                        // System.out.println(b+" "+c);
                        if((b.equals("A")||b.equals("D")||b.equals("W")||b.equals("S"))&&c<=99&&c>=1){
                            if(b.equals("A")){
                                x=x-c;
                            }
                            if(b.equals("D")){
                                x=x+c;
                            }
                            if(b.equals("W")){
                                y=y+c;
                            }
                            if(b.equals("S")){
                                y=y-c;
                            }else{continue;}
                        }
                    }
                }
            }

        }
        System.out.println(x+","+y);
    }
}
