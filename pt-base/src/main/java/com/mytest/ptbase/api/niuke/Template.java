package com.mytest.ptbase.api.niuke;
import java.util.*;


//质数判断，一个数由哪些质数相乘
public class Template {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLong()) { // 注意 while 处理多个 case
            Long num = in.nextLong();
            ArrayList<Long> list=new ArrayList<>();
            Template template=new Template();
            list=template.findPrime(num,list);
            StringBuilder stringBuilder=new StringBuilder();
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i).toString()+" ");
            }
            System.out.println(stringBuilder.toString());
        }
    }

    //递归
    public  ArrayList<Long> findPrime(Long num,ArrayList<Long> list){
        for (Long i = 2L; i <= num; i++) {
            if (num % i == 0) {
                if(Template.isPrime(i)){
                    list.add(i);
                    num=num/i;
                    if(Template.isPrime(num)){
                        list.add(num);
                        break;}else{findPrime(num,list);}
                }
                break;
            }
        }
        return list;
    }
    //判断是否是质数
    public static boolean isPrime(Long num) {
        if (num <= 1) {
            return false;
        }
        for (Long i = 2L; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
