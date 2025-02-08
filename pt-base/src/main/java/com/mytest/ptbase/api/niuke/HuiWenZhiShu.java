package com.mytest.ptbase.api.niuke;

import org.omg.CORBA.VisibilityHelper;

import java.util.Scanner;

//生成大于N的回文质数（回文素数），质数就是素数
public class HuiWenZhiShu {
    public static void main(String[] args) {
        HuiWenZhiShu z=new HuiWenZhiShu();
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while(in.hasNextInt()) {
            int N = in.nextInt();
            for (int i = N; ; i++) {
//            System.out.println(z.isHuiwen(i));
//            System.out.println(z.isPrime(i));
                if (z.isHuiwen(i) && z.isPrime(i)) {
                    System.out.println(i);
//                System.out.println(z.generateHuiWenOdd(985));//生成回文奇数的方法
//                System.out.println(z.generateHuiWenOu(985));//生成回文偶数的方法
                    break;
                }
            }
        }


    }
    public boolean isPrime(int i){
        if(i==1){return false;}
        if(i%2==0){return i==2;}
        for(int k=3;k<=(int)Math.sqrt(i);k=k+2){
            if(i%k==0){return false;}
        }
        return true;
    }
    public boolean isHuiwen(int i){
        String s=String.valueOf(i);
        for(int k=0;k<s.length();k++){
            if(s.charAt(k)!=s.charAt(s.length()-1-k)){
                return false;
            }
        }
        return true;

    }
    public int generateHuiWenOdd(int i){
        int huiwen=i;
        i/=10;//生成回文奇数
//        i/=10;//i/=10;去掉生成回文偶数
        while(i>0){
            huiwen=huiwen*10+i%10;
            i/=10;
        }
        return huiwen;
    }

    public int generateHuiWenOu(int i){
        int huiwen=i;
        while(i>0){
            huiwen=huiwen*10+i%10;
            i/=10;
        }
        return huiwen;
    }

//新的方法，参考答案；
    public int primePalindrome(int n) {
        if(n<=11){
            int k=n;
            while(!isPrime(k)){
                k++;
            }
            return k;
        }
        int minHuiwenPrime=0;

        int count=10;//11,22,33...99都不是质数，都能除以11.所以不考虑。且，生成的偶数回文数都能被11整除。所以不考虑生成偶数回文数。
        while(minHuiwenPrime==0){
            int huiwen=generateHuiWenOdd(count);
            if(huiwen>=n&&isPrime(huiwen)){
                minHuiwenPrime=huiwen;
            }else{count++;}
        }
        // while(minHuiwenPrime==0){
        //     int huiwen=generateHuiWenOu(count);
        //     if(huiwen>=n&&isPrime(huiwen)){
        //         minHuiwenPrime=Math.min(minHuiwenPrime,huiwen);
        //     }else{count++;}
        // }
        return minHuiwenPrime;
    }
}
