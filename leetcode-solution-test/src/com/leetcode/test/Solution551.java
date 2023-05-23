package com.leetcode.test;

/**
 * @ClassName: Solution551
 * @Description: TODO
 * @Author: TIEHAN WANG
 * @Date: 2023/5/23 21:57
 * @Version: v1.0
 */
public class Solution551 {
	public boolean checkRecord(String s) {
		int a = 0,l=0;
		for (char c : s.toCharArray()) {
			if (c == 'A' || c == 'P') l = 0;
			if (c == 'A') a++;
			if (c == 'L') l++;
			if(l>=3 || a>=2) return false;
		}
		return true;
	}
}
