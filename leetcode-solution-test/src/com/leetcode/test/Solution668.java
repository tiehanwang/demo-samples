package com.leetcode.test;

/**
 * @ClassName: Solution668
 * @Description: Solution leetcode question 668
 * @Author: TIEHAN WANG
 * @Date: 2022/5/18 14:33
 * @Version: v1.0
 */
public class Solution668 {
	public int findKthNumber (int m, int n, int k) {
		int left = 1, right = m * n;
		//对于第i行小于mid的个数为 min(mid/i,n) 对于i<mid/n时 mid/i均大于n 反之则小于 所以可把min拆分 为n* mid/n +i从mid/n+1开始
		while (left < right) {
			int mid = left + (right - left) / 2;
			int count = mid / n * n;
			for (int i = mid / n + 1; i <= m; i++) {
				count += mid / i;
			}
			//必须要找到符合要求并且最小的数字 在等于k时不返回而是让符合条件的 mid 尽可能小
			if (count >= k) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
