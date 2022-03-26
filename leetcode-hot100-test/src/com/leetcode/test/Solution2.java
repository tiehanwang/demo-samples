package com.leetcode.test;

import com.leetcode.entity.ListNode;

/**
 * @ClassName: Solution2
 * @Description: Solution leetcode hot100 question 2
 * @Author: TIEHAN WANG
 * @Date: 2022/3/26 11:26
 * @Version: v1.0
 */
public class Solution2 {
    //双指针遍历 相加即可 留个哨兵返回
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        dummy.next = l1;
        ListNode s1 = l1;
        ListNode s2 = l2;
        ListNode pre = dummy;
        int res = 0;
        while(s1!=null && s2 !=null){
            s1.val+=s2.val+res;
            res = 0;
            if(s1.val >=10){
                s1.val-=10;
                res = 1;
            }
            pre = pre.next;
            s1 = s1.next;
            s2 = s2.next;
        }
        if(s1 != null){
            while (s1!=null){
                s1.val += res;
                res = 0;
                if(s1.val>=10){
                    s1.val-=10;
                    res = 1;
                }
                s1 = s1.next;
                pre = pre.next;
            }
        }else{
            pre.next = s2;
            while (s2 != null){
                s2.val +=res;
                res = 0;
                if(s2.val >= 10){
                    s2.val -=10;
                    res = 1;
                }
                s2 = s2.next;
                pre =pre.next;
            }
        }
        if(res == 1){
            pre.next = new ListNode(1);
        }
        return dummy.next;
    }
}
