package com.leetcode.test;

/**
 * @ClassName: Solution905
 * @Description: Solution leetcode question 905
 * @Author: TIEHAN WANG
 * @Date: 2022/4/28 9:59
 * @Version: v1.0
 */
public class Solution905 {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0,j = 0;
        int n = nums.length;
        while(i < n && j<n){
            while (j<n && nums[j]%2 == 1) j++;
            if(j < n && nums[j] %2 == 0){
                int swap = nums[i];
                nums[i] = nums[j];
                nums[j] = swap;
            }
            j++;
            i++;
        }
        return nums;
    }
    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        for (int i = 0,j = n-1; i < j;i++) {
            if(nums[i] %2 == 1){
                int swap = nums[i];
                //i需要再次检查
                nums[i--] = nums[j];
                nums[j--] = swap;
            }
        }
        return nums;
    }

    public static void main (String[] args) {
        Solution905 solution905 = new Solution905();
        solution905.sortArrayByParity(new int[]{0,1});
    }
}
