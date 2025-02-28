package com.mytest.ptbase.api.LTBai;

import java.util.*;

//导师请吃火锅,火锅，https://renjie.blog.csdn.net/article/details/130755834
//动态规划。排序后，按手速时间取t=t+m，不能这么做，这是一道动态规划的题
public class HuoGuo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] firstHang=in.nextLine().split(" ");
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            int n = Integer.valueOf(s[0]);//菜
            int m = Integer.valueOf(s[1]);//手速
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int[] firstHang = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                set.add(firstHang[0] + firstHang[1]);
            }
            ArrayList<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            int startTime = list.get(0);
            int endTime = list.get(list.size() - 1);
            int[] dp = new int[endTime + 1];
            dp[0] = 0;
            dp[startTime] = 1;
            for (int i = startTime + 1; i <= endTime; i++) {
                if (list.contains(i)) {
                    dp[i] = Math.max(dp[i - 1], dp[Math.max(0, i - m)] + 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
                System.out.println(dp[endTime]);

//            int count=0;
//            for(int t=list.get(0);t<=list.get(list.size()-1);t=t+m){
//                for(int i=0;i<n;i++){
//                    if(t==list.get(i)){
//                        count++;
//                        break;
//                    }
//                }
//            }
//            System.out.println(count);
        }
    }
}
