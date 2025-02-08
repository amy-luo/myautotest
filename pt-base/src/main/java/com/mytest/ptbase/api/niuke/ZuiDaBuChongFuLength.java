package com.mytest.ptbase.api.niuke;

//滑窗，5道题
//不重复字符的最长子串：两个指针，起始位置i不断往右走，遍历i+1个元素是否与前面有重复
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长
//        子串
//        的长度。
//
//
//
//        示例 1:
//
//        输入: s = "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//        示例 2:
//
//        输入: s = "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//        示例 3:
//
//        输入: s = "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

import java.util.HashMap;
import java.util.TreeMap;

public class ZuiDaBuChongFuLength {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder stb = new StringBuilder();
            stb.append(s.substring(i, i + 1));
            for (int j = i + 1; j < s.length(); j++) {
                String dong = s.substring(j, j + 1);
                if (stb.toString().contains(dong)) {
                    break;
                } else {
                    stb.append(dong);
                }
            }
            max = Math.max(max, stb.toString().length());
        }
        return max;
    }

    //    给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
//    示例 1：
//
//    输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//    输出：6
//    解释：[1,1,1,0,0,1,1,1,1,1,1]
//    粗体数字从 0 翻转到 1，最长的子数组长度为 6。
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int fz = k;
            int sum = 0;
            if (nums[i] == 1) {
                sum++;
            } else if (nums[i] != 1) {
                if (fz > 0) {
                    fz--;
                    sum++;
                } else {
                    continue;
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 1) {
                    sum++;
                } else if (nums[j] != 1) {
                    if (fz > 0) {
                        fz--;
                        sum++;
                    } else {
                        break;
                    }
                    ;
                }
            }
            max = Math.max(max, sum);
        }
        return max;

    }

    //绝对差不超过限制的子字符串；中等难度，但我做起来超难。左右指针移动的算法，确定右指针，找离右指针最大的左指针，记录下来，再移动右指针，移动左指针。
    public int longestSubarray(int[] nums, int limit) {
        int maxSum = 0;
        int left = 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer,Integer>();
        int right = 0;
        while (right<nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left])-1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            maxSum = Math.max(maxSum, right - left+1);
            right++;
        }
        return maxSum;
    }

    //最小覆盖子串
    // 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    //注意：
    //对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    //如果 s 中存在这样的子串，我们保证它是唯一的答案。
    //
    //示例 1：
    //
    //输入：s = "ADOBECODEBANC", t = "ABC"
    //输出："BANC"
    //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){return "";}
        if(t.length()==0){return s;}
        if(s.length()==1){if(s.equals(t)){return s;}}
        int min = s.length();
        int left = 0;
        int right = t.length() - 1;
        String smin="";

        for (char c : t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (char c : s.substring(left, right).toCharArray()) {
            if(map2.containsKey(c)){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        while (right < s.length()) {
            if(map2.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            }
            boolean flag=true;
            while(check()){
                int count = 0;
                String res = s.substring(left, right+1);
                // System.out.println(res);
                // System.out.println(right - left + 1);
                if (right - left + 1 <=min) {
                    min = right - left + 1;
                    smin=res;
                    // System.out.println(smin);
                }
                if (right - left + 1 == t.length()) {
                    return res;
                }else{
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                        if (map.get(s.charAt(left)) == 0) {
                            map.remove(s.charAt(left));
                        }
                    }
                    left++;
                    // System.out.println("left:"+left);
                    continue;
                }
            }
            right++;
            // System.out.println("right:"+right);
        }
        return smin;
    }

    public boolean check(){
        for (Character c : map2.keySet()) {
            // System.out.println("map.get(c) == map2.get(c):"+map.get(c) +" "+ map2.get(c));
            if (map.getOrDefault(c,0) < map2.get(c)) {return false;}
        }
        return true;
    }
}
