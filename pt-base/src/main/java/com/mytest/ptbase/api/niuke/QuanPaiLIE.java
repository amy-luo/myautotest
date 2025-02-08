package com.mytest.ptbase.api.niuke;

import java.util.*;
//递归回溯：
//全排列并去重：https://leetcode.cn/problems/permutations-ii/description/
//https://renjie.blog.csdn.net/article/details/142267363
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
//        示例 1：
//
//        输入：nums = [1,1,2]
//        输出：
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
//        示例 2：
//
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//        提示：
//
//        1 <= nums.length <= 8
//        -10 <= nums[i] <= 10
public class QuanPaiLIE {
    boolean[] isExist;
    List<List<Integer>> solutions = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> subList = new ArrayList<Integer>();
        isExist = new boolean[nums.length];
        Arrays.sort(nums);//排序
        backtrack(nums, 0, subList);
        return solutions;
    }

    public void backtrack(int[] nums, int index, List<Integer> subList) {//index是全排列子数组的长度的指针
        if (index== nums.length) {//终止，subList被填满数组长度时
            solutions.add(new ArrayList<Integer>(subList));//将List<Integer> subList转为ArrayList<Integer>再被添加
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (isExist[i] || (i > 0 && nums[i] == nums[i - 1] && !isExist[i - 1])) {//相同元素如果左边的元素没加过，后面相同的这个元素就不能加，优先左边元素，有序，目的是去重
                continue;//如果元素已存在就跳过。相同元素如果左边没加就跳过，左边加了可以加。相同元素是要有序的，目的是去重。
            }
            subList.add(nums[i]);//增加该元素
            isExist[i] = true;//数组中某元素的索引已被添加
            backtrack(nums,  index + 1, subList);//递归
            isExist[i] = false;//数组中某元素的索引已被删除
            subList.remove(index);//删除该元素，跳过该元素的情况
        }
    }
}
