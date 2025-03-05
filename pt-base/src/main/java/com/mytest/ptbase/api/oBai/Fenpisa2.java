package com.mytest.ptbase.api.oBai;

import java.util.*;

public class Fenpisa2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();
            }

            long[][] memory = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    memory[i][j] = 0L;
                }
            }

            long result = 0;
            int i=0;
            while(true){
                if(i>=n){
                    break;
                } else {
                    int left = (i + n + 1) % n;
                    int right = (i + n - 1) % n;
                    long target = backtrace(left, right, nums, memory,n);
                    if(target+nums[i] > result){
                        result = target+nums[i];
                    }
                }
                i+=1;
            }
            System.out.println(result);

        }

        public static long backtrace(int left, int right, int[] nums, long[][] memory, int n) {
            if(nums[left] > nums[right]){
                left = left < 0 ? left : (left + n + 1) % n;
            }else if(nums[left] < nums[right]){
                right = right < 0 ? right : (right + n - 1) % n;
            }

            if (memory[left][right] <= 0) {
                if (left == right) {
                    memory[left][right] = nums[left];
                } else {
                    int new_left = (left + 1) % n;
                    int new_right = (right + n - 1) % n;
                    memory[left][right] = nums[left] + backtrace(new_left, right, nums, memory,n);
                    if(nums[right] + backtrace(left,new_right , nums, memory,n) > memory[left][right]){
                        memory[left][right] = nums[right] + backtrace(left,new_right , nums, memory,n);
                    }
                }
                return memory[left][right];
            } else {
                return memory[left][right];
            }
        }
}
