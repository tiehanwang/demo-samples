package com.leetcode.test;

/**
 * @ClassName: Solution396
 * @Description: Solution leetcode question 396
 * @Author: TIEHAN WANG
 * @Date: 2022/4/22 23:39
 * @Version: v1.0
 */
public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0, f = 0, n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i]; // 计算F(0)
        }
        ans = f;
        for (int i = 1; i < n; i++) { // 迭代计算F(i)
            f = f + sum - n * nums[n-i]; // F(i) = F(i-1) + sum - n * A(n-i)
            ans = Math.max(ans, f);
        }
        return ans;
    }
}
