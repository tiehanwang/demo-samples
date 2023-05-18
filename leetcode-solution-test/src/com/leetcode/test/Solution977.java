package com.leetcode.test;

/**
 * @ClassName: Solution977
 * @Description: TODO
 * @Author: TIEHAN WANG
 * @Date: 2023/5/19 1:16
 * @Version: v1.0
 */
public class Solution977 {
	public int[] sortedSquares(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
			if (nums[i] * nums[i] > nums[j] * nums[j]) {
				ans[pos] = nums[i] * nums[i];
				++i;
			} else {
				ans[pos] = nums[j] * nums[j];
				--j;
			}
			--pos;
		}
		return ans;
	}
}
