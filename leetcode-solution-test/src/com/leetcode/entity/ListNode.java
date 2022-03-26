package com.leetcode.entity;

/**
 * @ClassName: ListNode
 * @Description: ListNode
 * @Author: TIEHAN WANG
 * @Date: 2022/3/26 11:41
 * @Version: v1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode () {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}