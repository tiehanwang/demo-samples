package com.leetcode.test;

/**
 * @ClassName: Solution944
 * @Description: Solution leetcode question 944
 * @Author: TIEHAN WANG
 * @Date: 2022/5/12 23:18
 * @Version: v1.0
 */
public class Solution944 {
	public int minDeletionSize(String[] strs) {
		int row = strs.length;
		int col = strs[0].length();
		int ans = 0;
		for (int j = 0; j < col; ++j) {
			for (int i = 1; i < row; ++i) {
				if (strs[i - 1].charAt(j) > strs[i].charAt(j)) {
					ans++;
					break;
				}
			}
		}
		return ans;
	}
}
