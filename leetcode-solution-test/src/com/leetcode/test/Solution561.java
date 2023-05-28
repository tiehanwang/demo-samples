package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution561
 * @Description: TODO
 * @Author: TIEHAN WANG
 * @Date: 2023/5/28 11:05
 * @Version: v1.0
 */
public class Solution561 {
	public int arrayPairSum(int[] nums) {
		int result = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i+=2) {
			result += nums[i];
		}
		return result;
	}
}
