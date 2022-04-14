package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution1672
 * @Description: Solution leetcode question 1672
 * @Author: TIEHAN WANG
 * @Date: 2022/4/14 10:17
 * @Version: v1.0
 */
public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = Arrays.stream(account).sum();
            max = Math.max(sum,max);
        }
        return max;
    }
}
