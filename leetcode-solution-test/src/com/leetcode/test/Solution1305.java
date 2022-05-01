package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution1305
 * @Description: Solution leetcode question 1305
 * @Author: TIEHAN WANG
 * @Date: 2022/5/1 9:53
 * @Version: v1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode () {
    }

    TreeNode (int val) {
        this.val = val;
    }

    TreeNode (int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//中序遍历+归并
public class Solution1305 {
    List<Integer> list1;
    List<Integer> list2;

    public List<Integer> getAllElements (TreeNode root1, TreeNode root2) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        List<Integer> res = new ArrayList<>();
        int i , j;
        for ( i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            if (list1.get(i) <list2.get(j)){
                res.add(list1.get(i++));
            }else{
                res.add(list2.get(j++));
            }
        }
        while (i<list1.size()){
            res.add(list1.get(i++));
//            res.addAll(list1.subList(i,list1.size()));
        }
        while (j<list2.size()){
            res.add(list2.get(j++));
//            res.addAll(list2.subList(j,list2.size()));
        }
        return res;
    }

    public void dfs (TreeNode root,List<Integer> list) {
        if(root == null) return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
