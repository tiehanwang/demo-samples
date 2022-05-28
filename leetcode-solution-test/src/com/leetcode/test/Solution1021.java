package com.leetcode.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution1021
 * @Description: Solution leetcode question 1021
 * @Author: TIEHAN WANG
 * @Date: 2022/5/28 9:10
 * @Version: v1.0
 */
public class Solution1021 {
	public String removeOuterParentheses(String s) {
		Deque<Character> deque = new LinkedList<>();
		int length = s.length();
		StringBuilder all = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if(c == ')'){
				deque.removeLast();
			}
			if(!deque.isEmpty()){
				all.append(c);
			}
			if(c == '('){
				deque.add(c);
			}
		}
		return all.toString();
	}

	public static void main (String[] args) {
		Solution1021 solution1021 = new Solution1021();
		solution1021.removeOuterParentheses("(()())(())(()(()))");

	}
}
