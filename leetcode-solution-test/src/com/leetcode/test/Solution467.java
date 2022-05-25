package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution467
 * @Description: Solution leetcode question 467
 * @Author: TIEHAN WANG
 * @Date: 2022/5/25 9:20
 * @Version: v1.0
 */
public class Solution467 {
	public int findSubstringInWraproundString(String p) {
		int k = 0;
		int n = p.length();
		int[] dp = new int[26];
		for (int i = 0; i < n; i++) {
			//当前点减去前值差值是否为 1（ab）或-25（za）
			if(i>0 &&(p.charAt(i)-p.charAt(i-1)+26)%26 == 1){
				k++;
			}else{
				k = 1;
			}
			dp[p.charAt(i)-'a'] = Math.max(dp[p.charAt(i)-'a'],k);
		}
		return Arrays.stream(dp).sum();
	}

	public static void main (String[] args) {
		Solution467 solution467 = new Solution467();
		solution467.findSubstringInWraproundString("zaba");
	}
}
