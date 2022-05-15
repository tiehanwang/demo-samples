package com.leetcode.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Solution20
 * @Description: Solution leetcode question 20
 * @Author: TIEHAN WANG
 * @Date: 2022/5/15 16:15
 * @Version: v1.0
 */
public class Solution20 {
	public boolean isValid(String s) {
		Deque<Character> deque = new LinkedList<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
				deque.addLast(s.charAt(i));
			}else if(s.charAt(i) == ')'){
				if(deque.isEmpty()||deque.getLast() != '(') return false;
				deque.removeLast();
			}else if(s.charAt(i) == '}'){
				if(deque.isEmpty()||deque.getLast() != '{') return false;
				deque.removeLast();
			}else if(s.charAt(i) == ']'){
				if (deque.isEmpty()||deque.getLast() !='[') return false;
				deque.removeLast();
			}
		}
		return deque.isEmpty();
	}
}
