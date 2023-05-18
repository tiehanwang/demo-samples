package com.leetcode.test;

import com.leetcode.entity.ListNode;

/**
 * @ClassName: Solution876
 * @Description: TODO
 * @Author: TIEHAN WANG
 * @Date: 2023/5/19 1:15
 * @Version: v1.0
 */
public class Solution876 {

	public ListNode middleNode(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
