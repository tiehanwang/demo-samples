package com.leetcode.test;

/**
 * @ClassName: Solution942
 * @Description: Solution leetcode question 942
 * @Author: TIEHAN WANG
 * @Date: 2022/5/9 9:20
 * @Version: v1.0
 */
public class Solution942 {
	public int[] diStringMatch(String s) {
		int[] res = new int[s.length()+1];
		int length = s.length();
		int min = 0;
		int max = s.length();
		for (int i = 0; i < length; i++) {
			if(s.charAt(i) == 'I'){
				res[i] = min;
				min++;
			}else{
				res[i] = max;
				max--;
			}
		}
		res[length] = max;
		return res;
	}

	public static void main (String[] args) {
		Solution942 solution942 = new Solution942();
		solution942.diStringMatch("IDID");
	}
}
