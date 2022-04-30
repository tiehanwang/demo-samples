package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution908
 * @Description: Solution leetcode question 908
 * @Author: TIEHAN WANG
 * @Date: 2022/4/30 20:12
 * @Version: v1.0
 */
public class Solution908 {
    //简单模拟
    public int smallestRangeI(int[] nums, int k) {
        // int n = nums.length;
        // int max = -1;
        // int min = Integer.MAX_VALUE;
        // for(int i = 0;i<n;i++)
        // {
        //     if(nums[i]<min){
        //         min = nums[i];
        //     }
        //     if(nums[i]>max){
        //         max = nums[i];
        //     }
        // }
        // int val = max - min;
        // if(val<2*k){
        //     return 0;
        // }
        // return val-2*k;
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return (max-min)<2*k ? 0:(max-min-2*k);
    }
}
