package com.leetcode.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: Solution449
 * @Description: Solution leetcode question 449
 * @Author: TIEHAN WANG
 * @Date: 2022/5/11 20:54
 * @Version: v1.0
 */
public class Solution449 {
}
 class Codec {
	public String serialize(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postOrder(root, list);
		String str = list.toString();
		return str.substring(1, str.length() - 1);
	}

	public TreeNode deserialize(String data) {
		if (data.isEmpty()) {
			return null;
		}
		String[] arr = data.split(", ");
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			stack.push(Integer.parseInt(arr[i]));
		}
		return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
	}

	private void postOrder(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
	}

	private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
		if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
			return null;
		}
		int val = stack.pop();
		TreeNode root = new TreeNode(val);
		root.right = construct(val, upper, stack);
		root.left = construct(lower, val, stack);
		return root;
	}
}