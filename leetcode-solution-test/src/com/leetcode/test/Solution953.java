package com.leetcode.test;

/**
 * @ClassName: Solution953
 * @Description: Solution leetcode question 953
 * @Author: TIEHAN WANG
 * @Date: 2022/5/17 22:06
 * @Version: v1.0
 */
public class Solution953 {
	public boolean isAlienSorted(String[] words, String order) {
		int[] index = new int[26];
		for (int i = 0; i < order.length(); ++i) {
			index[order.charAt(i) - 'a'] = i;
		}
		for (int i = 1; i < words.length; i++) {
			boolean valid = false;
			for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
				int prev = index[words[i - 1].charAt(j) - 'a'];
				int curr = index[words[i].charAt(j) - 'a'];
				if (prev < curr) {
					valid = true;
					break;
				} else if (prev > curr) {
					return false;
				}
			}
			if (!valid) {
				/* 比较两个字符串的长度 */
				if (words[i - 1].length() > words[i].length()) {
					return false;
				}
			}
		}
		return true;
	}
}
