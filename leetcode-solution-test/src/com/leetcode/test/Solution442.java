package com.leetcode.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution442
 * @Description: Solution leetcode question 442
 * @Author: TIEHAN WANG
 * @Date: 2022/5/8 14:45
 * @Version: v1.0
 */
//如果不限制空间的话则选择很多比如hash表 比如排序等等
//如果现在常数空间则可选用交换位置做法
//给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。

public class Solution442 {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new LinkedList<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			 if(nums[i] != nums[nums[i]-1]){
				int swap = nums[i];
				nums[i] = nums[swap-1];
				nums[swap-1] = swap;
				i--;
			 }
		}
		for (int i = 0; i < nums.length; i++) {
			if((nums[i]-1) != i){
				list.add(nums[i]);
			}
		}
		return list;
	}

	public static void main (String[] args) {
		Solution442 solution442  =new Solution442();
		for (Integer duplicate : solution442.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})) {
			System.out.println(duplicate);
		}
	}
}
