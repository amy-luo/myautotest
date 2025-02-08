package com.mytest.ptbase.api.niuke;
import com.alibaba.fastjson.JSON;

import java.util.*;

public class NiukeTest {
    public static void main(String[] args) {
        //常用方法
        //扫描输入
        Scanner in = new Scanner(System.in);
        in.hasNext();
        in.hasNextInt();
        in.hasNextLine();
        in.next();
        in.nextLong();
        in.nextLine();

        //字符串的长度
        String s = "3fgretw";
        s.length();

        //数组的长度
        String[] a = {"werqwe", "2eweqrewrq"};
        a[0] = "werqwe";
        a[1] = "2eweqrewrq";
        a[1].length();
        int[] array = new int[2];
        array[0] = 1;
        array[1] = 2;

        //Character的用法
        Character.isDigit('1');//是否是数字
        Character.isUpperCase('A');//是否是大写字母
        Character.isLowerCase('b');//是否是小写字母
        "Ab".equalsIgnoreCase("aB");//忽略大小写的判断相等

        String[] sin = s.split("");
        int count = 0;
        for (String o : sin) {
            if (String.valueOf(a[0].charAt(0)).equalsIgnoreCase(o)) {
                count++;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        ArrayList<Integer> list = new ArrayList<>(set);
        list.addAll(set);

        char ch = '5';
        int value = Character.getNumericValue(ch);
        System.out.println(value); // 输出 5，字符转数字

        String str = "123";
        value = Integer.parseInt(str);
        System.out.println(value); // 输出 123，字符串转数字


        Collections.sort(list);//将单词从小到大排序也是用这个
        // 使用Collections.sort()和自定义比较器进行降序排序，默认是升序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); // 降序排列
            }
        });

             Collections.sort(list);//list 排序
             int[] nums={2,3,5,3,2,3};
             int k=3;
             Arrays.sort(nums);//数组排序
             int large= nums[nums.length-k];//第k个最大值


        // 或者使用Lambda表达式简化，从大到小排序
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));


        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] ab = in.nextLine().split(" ");

            int b = ab[ab.length - 1].length();
            System.out.println(b);
        }

        //去重和排序，hashSet，ArrayList排序
        HashSet<Integer> set2 = new HashSet<>();
        in.nextLine();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            Integer ab = Integer.valueOf(in.nextLine());
            set.add(ab);
        }
        ArrayList<Integer> list2 = new ArrayList<>(set2);
        Collections.sort(list);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
//16进制转10进制，字符转字符串，字符转数字，Character获取字符转数据，判断字符是否是数字，
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String snew = in.nextLine();
            String s16;
            count = 0;
            if (snew.substring(0, 2).equals("0x")) {
                s16 = snew.substring(2);
                int num = s16.length();
                for (int i = 0; i < num; i++) {
                    if (s16.charAt(i) == 'A') {
                        count = count + (int) (Math.pow(16, num - 1 - i)) * 10;
                    }
                    if (s16.charAt(i) == 'B') {
                        count = count + 11 * (int) (Math.pow(16, num - 1 - i));
                    } else if (s16.charAt(i) == 'C') {
                        count = count + 12 * (int) (Math.pow(16, num - 1 - i));
                    } else if (s16.charAt(i) == 'D') {
                        count = count + 13 * (int) (Math.pow(16, num - 1 - i));
                    } else if (s16.charAt(i) == 'E') {
                        count = count + 14 * (int) (Math.pow(16, num - 1 - i));
                    } else if (s16.charAt(i) == 'F') {
                        count = count + 15 * (int) (Math.pow(16, num - 1 - i));
                    } else if (Character.isDigit(s16.charAt(i))) {
                        // int a=Integer.parseInt(String.valueOf(s16.charAt(i)));
                        int af = Character.getNumericValue(s16.charAt(i));
                        count = count + af * (int) (Math.pow(16, num - 1 - i));
                    }
                }
            }
            System.out.println(count);
        }
        //取近似值，四舍五入
        while (in.hasNextDouble()) { // 注意 while 处理多个 case
            Double at = in.nextDouble();
            System.out.println((int)(at+0.5));
        }
        JSON.toJSONString(a);
        Collections.max(list);//求最大值

    }





}
