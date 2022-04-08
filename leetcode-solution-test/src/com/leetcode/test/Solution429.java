package com.leetcode.test;

import com.leetcode.entity.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: Solution429
 * @Description: Solution leetcode question 429
 * @Author: TIEHAN WANG
 * @Date: 2022/4/8 10:17
 * @Version: v1.0
 */
public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> res =  new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if(poll!=null){
                    res.add(poll.val);
                    for (Node child : poll.children) {
                        queue.offer(child);
                    }
                }
            }
            list.add(res);
        }
        return list;
    }
}
