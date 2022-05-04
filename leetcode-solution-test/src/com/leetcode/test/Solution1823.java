package com.leetcode.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Solution1823
 * @Description: leetcode 1823 Solution
 * @Author: TIEHAN WANG
 * @Date: 2022/5/4 10:55
 * @Version: v1.0
 */
public class Solution1823 {
    //模拟or约瑟夫环
    public int findTheWinner(int n, int k) {
        if(n<=1) return n;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i ++ ) q.add(i);
        for (int i = 1; i < n; i ++ ) {
            for (int j = 1; j < k; j ++ ) q.add(q.poll());
            q.poll();
        }
        return q.poll();
    }
    //约瑟夫环
    public int findTheWinner2(int n, int k) {
        int p = 0;
        for (int i = 1; i <= n; i++) {
            p = (p+k)%i;
        }
        return p+1;
    }
}
