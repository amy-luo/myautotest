package com.mytest.ptbase.api.niuke;

public class HuiWenShu {
    public int superpalindromesInRange(String left, String right) {
        int sum=0;
        long L=Long.valueOf(left);
        long R=Long.valueOf(right);
        //奇数
        for(int k=1;k<100000;k++){
            StringBuilder stb=new StringBuilder(Integer.toString(k).toString());
            for(int i=stb.length()-2;i>=0;i--){
                stb.append(stb.charAt(i));
            }
            long value=Long.valueOf(stb.toString());

            value=value*value;
            if(value>R){break;}
            if(value>=L&&isHuiWen(String.valueOf(value))){
                System.out.println(value);
                sum++;
            };

        }
//偶数
        for(int k=1;k<100000;k++){
            StringBuilder stb=new StringBuilder(Integer.toString(k).toString());
            for(int i=stb.length()-1;i>=0;i--){
                stb.append(stb.charAt(i));
            }
            long value=Long.valueOf(stb.toString());
            //  System.out.println(value);
            value=value*value;
            if(value>R){break;}
            if(value>=L&&isHuiWen(String.valueOf(value))){
                System.out.println(value);
                sum++;
            };

        }
        // for(long i=sqrtl;i<=sqrtr;i++){
        //     if(isHuiWen(String.valueOf(i))){
        //         long j=i*i;
        //         if(isHuiWen(String.valueOf(j))){
        //              System.out.println(j);
        //             sum++;
        //         }

        //     }
        // }
        return sum;

    }

    public boolean isHuiWen(String s){
        for ( int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            };
        }
        return true;
    }
}
