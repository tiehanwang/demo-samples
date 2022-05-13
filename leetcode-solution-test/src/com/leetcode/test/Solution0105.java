package com.leetcode.test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @ClassName: Solution0105
 * @Description: Solution leetcode question 01-05
 * @Author: TIEHAN WANG
 * @Date: 2022/5/13 9:21
 * @Version: v1.0
 */
public class Solution0105 {
	public boolean oneEditAway (String first, String second) {
		int n = first.length();
		int m = second.length();
		if (Math.abs(n - m) > 1) return false;
		//放到队列中依次弹出
		int i = 0, j = 0;
		int flag = 0;
		if (n > m) return oneEditAway(second, first);
		//令f<=s
		while (i < n && j < m) {
			if (first.charAt(i) == second.charAt(j)) {
				i++;
				j++;
			} else if (n == m) {
				i++;
				j++;
				flag++;
			} else {
				j++;
				flag++;
			}
			if (flag > 1) {
				return false;
			}
		}
		return true;
	}
}
