package com.leetcode.test;

/**
 * @ClassName: Solution713
 * @Description: Solution leetcode question 713
 * @Author: TIEHAN WANG
 * @Date: 2022/5/5 11:02
 * @Version: v1.0
 */
//滑动窗口 j每前进一位则加j-i+1位 注意 题意是以j为边界的 可以理解为j开头 例如0-1 到 0-2 加入的就是 2 2-1 2-1-0
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int res = 0;
        int prod = 1;
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (i<=j && prod>=k){
                prod /=nums[i];
                i++;
            }
            res +=  j-i+1;
        }
        return res;
    }
}
