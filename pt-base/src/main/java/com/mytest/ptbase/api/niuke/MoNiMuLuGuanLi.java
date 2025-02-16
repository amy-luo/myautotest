package com.mytest.ptbase.api.niuke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//模拟目录管理，https://renjie.blog.csdn.net/article/details/136298282
//自定义内部类，模拟功能
public class MoNiMuLuGuanLi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();
        Directory root_dir=new Directory("/",null);
        Directory current_dir=root_dir;
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] mingling = s.split(" ");
            if (isMinXie(mingling)) {//判断是否是小写，去除"."
                if (mingling.length == 2&&!mingling[1].isEmpty()) {//判单是否是2
                    String dir_name = current_dir.name+mingling[1]+"/";//目录名称拼接
                    if(mingling[0].equals("mkdir")){
                        if(!current_dir.directMap.keySet().contains(dir_name)) {//当前目录名称是否重复
                            current_dir.directMap.put(dir_name, new Directory(dir_name, current_dir));
                        }
                    }else if(mingling[0].equals("cd")){
                        if(mingling[1].equals("..")){//切回上一级的情况
                            if(!current_dir.name.equals("/")) {//不是根目录时，当前若已是根目录不处理
                                current_dir = current_dir.directMap.get(mingling[1]);
                            }
                        }else{
                        current_dir=current_dir.directMap.get(dir_name);}//切到下一个文件夹的情况
                    }
                } else if (mingling[0].equals("pwd")) {
                    System.out.println(current_dir.name);
                }
            }
        }
    }

    private static boolean isMinXie(String[] mingling) {
        for(String s:mingling) {
            for (Character o : s.toCharArray()) {
                if (o!='.'&&('a' > o || o > 'z')) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Directory {
        public String name;
        public HashMap<String, Directory> directMap;

        public Directory(String name, Directory direct) {
            this.name = name;
            this.directMap = new HashMap<>();
            this.directMap.put("..", direct);
        }
    }
}
