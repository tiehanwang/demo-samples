package com.leetcode.test;

/**
 * @ClassName: Solution961
 * @Description: Solution leetcode question 954
 * @Author: TIEHAN WANG
 * @Date: 2022/5/21 16:08
 * @Version: v1.0
 */
public class Solution961 {
	//存到hashset直接解
	//不想消耗多余的内存 2*n个数字 n+1种 则必然重复数a和 a+1及a+2中的一个是相等的。
	public int repeatedNTimes(int[] nums) {
		for (int i = 0; i < nums.length - 2; i++) {
			if(nums[i] == nums[i+1]|| nums[i] == nums[i+2]){
				return nums[i];
			}
		}
		return nums[nums.length-1];
	}
}
