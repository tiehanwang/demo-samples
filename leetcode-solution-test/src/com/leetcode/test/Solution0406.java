package com.leetcode.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution0406
 * @Description: Solution leetcode question 04-06
 * @Author: TIEHAN WANG
 * @Date: 2022/5/16 9:15
 * @Version: v1.0
 */
public class Solution0406 {
//	//中序遍历 时间O(n)空间O(n)
//	List<TreeNode> list = new LinkedList<>();
//	int index;
//	TreeNode target;
//	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//		target = p;
//		inOrder(root);
//		if(index+1 >= list.size()) return null;
//		return list.get(index+1);
//	}
//	private void inOrder(TreeNode root){
//		if(root == null) return;
//		inOrder(root.left);
//		if(root.val == target.val) index = list.size();
//		list.add(root);
//		inOrder(root.right);
//	}
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		//右非空则结果必然在p的right中
		if(p.right != null){
			res = p.right;
			while (res.left !=null){
				res = res.left;
			}
			return res;
		}
		TreeNode node = root;
		while (node != null){
			//大于 说明p在当前节点左子树 故先把结果设为大于p的node
			if(node.val > p.val){
				res = node;
				node = node.left;
			}
			//小于等于则说明p在node的右子树 此时不需要设置结果 因为结果仍可能为空
			if(node.val <= p.val){
				node = node.right;
			}
		}
		return res;
	}

}
