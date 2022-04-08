package com.leetcode.entity;

import java.util.List;

/**
 * @ClassName: Node
 * @Description: Node entity
 * @Author: TIEHAN WANG
 * @Date: 2022/4/8 10:17
 * @Version: v1.0
 */
public class Node {
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
}
