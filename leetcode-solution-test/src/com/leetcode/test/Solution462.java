package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution462
 * @Description: Solution leetcode question 462
 * @Author: TIEHAN WANG
 * @Date: 2022/5/19 11:49
 * @Version: v1.0
 */
public class Solution462 {
	//就是求距离，题意可知点一定在排序后数组的两点之间。当为奇数时 此时对于两端点而言其距离和一定 对于临近端点的一对点则不然 故应该在每对点之间 可推广为中位数位置。
	// 当为偶数时最后一对端点闭区间哪个点都可以 因为二者和一定
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int mid = nums[nums.length/2];
		int res = 0;
		for (int num : nums) {
			res +=Math.abs(mid-num);
		}
		return res;
	}
}
