package com.leetcode.test;

import java.util.List;

/**
 * @ClassName: Solution559
 * @Description: TODO
 * @Author: TIEHAN WANG
 * @Date: 2023/5/28 11:04
 * @Version: v1.0
 */

public class Solution559 {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};
	public int maxDepth(Node root) {
		if (root == null) return 0;
		int depth = 0;
		for (Node children : root.children) {
			int childrenDepth = maxDepth(children);
			if (childrenDepth > depth)
				depth = childrenDepth;
		}
		return depth+1;
	}
}
