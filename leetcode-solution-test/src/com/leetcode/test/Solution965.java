package com.leetcode.test;

/**
 * @ClassName: Solution965
 * @Description: Solution leetcode question 965
 * @Author: TIEHAN WANG
 * @Date: 2022/5/24 14:13
 * @Version: v1.0
 */
public class Solution965 {
	public boolean isUnivalTree(TreeNode root) {
		if(root == null) return true;

		if(root.left !=null){
			if(root.left.val != root.val || !isUnivalTree(root.left)) return false;
		}
		if(root.right != null){
			if(root.right.val != root.val || !isUnivalTree(root.right)) return false;
		}
		return true;
	}
}
