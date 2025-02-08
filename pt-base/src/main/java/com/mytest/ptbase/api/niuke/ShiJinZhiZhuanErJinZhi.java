package com.mytest.ptbase.api.niuke;
import java.util.*;

public class ShiJinZhiZhuanErJinZhi {
        public static int i=0;
        public static int j=0;
        public static ArrayList<Integer> list=new ArrayList<>();
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextInt()) { // 注意 while 处理多个 case
                StringBuilder stringBuilder=new StringBuilder();
                int a = in.nextInt();
                ShiJinZhiZhuanErJinZhi.i=0;
                ShiJinZhiZhuanErJinZhi.j=0;
                if(a==0){System.out.println("0");}
                if(a==1){System.out.println("1");}
                if(a>1){
                    ShiJinZhiZhuanErJinZhi.getNum(a);
                    System.out.println(j);//统计二进制中1的个数
                }
                for(int o:ShiJinZhiZhuanErJinZhi.list){
                    stringBuilder.insert(0,o);//每次插入到第0个位置；
                }
                System.out.println(stringBuilder.toString());//将十进制转化为二进制输出

                //将十进制转化为二进制
                String binaryString = Integer.toBinaryString(a);
                String s=binaryString.replaceAll("1","");
                System.out.println(binaryString.length()-s.length()); // 输出二进制字符串，例如 "1010"

                //将十进制转化为二进制输出，Integer.toString(int, int)
                //这个方法可以用于转换任何基本数据类型为指定基数（进制）的字符串
                String binaryString2 = Integer.toString(a, 2);
//                String binaryString2 = Integer.toString(a, 16);//将任何基本数据类型转换成16进制或2进制
                String s2=binaryString.replaceAll("1","");
                System.out.println(binaryString2.length()-s2.length()); // 输出二进制字符串，例如 "1010"
            }

            //十进制转换为二进制
            int decimalNumber = 10; // 十进制数
            String binaryString = Integer.toBinaryString(decimalNumber);
            System.out.println(binaryString); // 输出二进制字符串，例如 "1010"

            //十进制转换为二进制，方法二
            String binaryString2 = Integer.toString(decimalNumber, 2);
            System.out.println(binaryString2); // 输出二进制字符串，例如 "1010"
        }

        public static void getNum(int a){
            if(a>0){
                ShiJinZhiZhuanErJinZhi.list.add(a%2);//将余数放入list
                if(a%2!=0){ShiJinZhiZhuanErJinZhi.j++;}
                a=a/2;//除以2后，将得数继续去除以2递归
                ShiJinZhiZhuanErJinZhi.i++;
                getNum(a);
            }
        }
}
