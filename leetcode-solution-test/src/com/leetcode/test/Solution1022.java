package com.leetcode.test;

/**
 * @ClassName: Solution1022
 * @Description: Solution leetcode question 1022
 * @Author: TIEHAN WANG
 * @Date: 2022/5/30 8:48
 * @Version: v1.0
 */
public class Solution1022 {


	public int sumRootToLeaf1(TreeNode root) {
		return dfs(root, 0);
	}

	public int dfs(TreeNode root, int val) {
		if (root == null) {
			return 0;
		}
		val = (val << 1) | root.val;
		if (root.left == null && root.right == null) {
			return val;
		}
		return dfs(root.left, val) + dfs(root.right, val);
	}


	int sum;
	public int sumRootToLeaf(TreeNode root) {
		sum = 0;
		if(root == null) return 0;
		search(root,0);
		return sum;
	}
	private void search(TreeNode root,int val){
			val= (val << 1)|root.val;
		if(root.left == null && root.right==null){
			sum+=val;
			return;
		}
		if(root.left!=null){
			search(root.left,val);
		}
		if(root.right !=null){
			search(root.right,val);
		}
	}

	public static void main (String[] args) {
		TreeNode treeNode = new TreeNode(1);
		TreeNode l1 = new TreeNode(0);
		TreeNode l2 = new TreeNode(1);
		treeNode.left = l1;
		treeNode.right = l2;
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(0);
		TreeNode t4 = new TreeNode(1);
		l1.left = t1;
		l1.right = t2;
		l2.left = t3;
		l2.right = t4;
		new Solution1022().sumRootToLeaf(treeNode);
	}
}
