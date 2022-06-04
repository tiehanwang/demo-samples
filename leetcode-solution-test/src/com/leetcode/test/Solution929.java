package com.leetcode.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution929
 * @Description: Solution leetcode question 929
 * @Author: TIEHAN WANG
 * @Date: 2022/6/4 20:49
 * @Version: v1.0
 */
public class Solution929 {
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		StringBuilder stringBuilder = new StringBuilder();
		for (String email : emails) {
			String[] split = email.split("\\+");
			String[] emailSplit = email.split("@");
			if(split.length == 1) {
				stringBuilder.append(emailSplit[0].replace(".","")).append("@").append(emailSplit[1]);
			}
			else{
				stringBuilder.append(split[0].replace(".", "")).append("@").append(emailSplit[1]);
			}
			set.add(stringBuilder.toString());
			stringBuilder.setLength(0);
		}
		return set.size();
	}

	public static void main (String[] args) {
		Solution929 solution929 = new Solution929();
		solution929.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"});
	}
}
