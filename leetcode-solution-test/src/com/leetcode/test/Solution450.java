package com.leetcode.test;

/**
 * @ClassName: Solution450
 * @Description: Solution leetcode question 450
 * @Author: TIEHAN WANG
 * @Date: 2022/6/2 10:06
 * @Version: v1.0
 */
public class Solution450 {
	//二叉查找树先找节点位置,找到后叶子节点直接返空,左右有一空返回另一个,
	//否则,查找当前节点对应的下一个点,即比下一个当前节点大的点去右子树左遍历,找到后返回当前节点的右节点
	//当前节点被分离,用当前节点把源要删除的节点替换即可,题外话 如果需要平衡 则平衡旋转一下.
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return root;
		if(root.val>key){
			root.left = deleteNode(root.left,key);
			return root;
		}else if(root.val<key){
			root.right = deleteNode(root.right,key);
			return root;
		}else {
			if(root.left == null && root.right == null) return null;
			if(root.right == null) return root.left;
			if(root.left == null) return root.right;
			TreeNode res = root.right;
			while (res.left !=null){
				res = res.left;
			}
			root.right = deleteNode(root.right,res.val);
			res.left = root.left;
			res.right = root.right;
			return res;
		}
	}
}
