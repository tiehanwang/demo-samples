package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution16
 * @Description: Solution leetcode question 16
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 8:58
 * @Version: v1.0
 */
public class Solution16 {

    //同15 排序+双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int dis = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int new_dis = nums[i]+nums[left]+nums[right];
                if(Math.abs(new_dis-target)<Math.abs(dis-target)){
                    dis = new_dis;
                }
                if(new_dis>target) right--;
                else if(new_dis<target) left++;
                else return new_dis;
            }
        }
        return dis;
    }
    //加了点特殊条件和去重
    public int threeSumClosest1(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int dis = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left< right){
                //当前循环条件下最小值和最大值
                int min = nums[i]+nums[left]+nums[left+1];
                int max = nums[i]+nums[right]+nums[right-1];
                //比最小值小 没必要继续遍历了 因为一定会继续增大
                if(min>target){
                    if(Math.abs(min-target) < Math.abs(dis-target)){
                        dis = min;
                    }
                    break;
                }
                //比最大值大 没必要继续遍历了 因为一定会越来越小
                if(max<target){
                    if(Math.abs(max-target) < Math.abs(dis-target)){
                        dis = max;
                    }
                    break;
                }
                int new_dis = nums[i]+nums[left]+nums[right];
                if(Math.abs(dis-target) > Math.abs(new_dis-target)){
                    dis = new_dis;
                }
                //去重 使用过的值可以去重
                if(new_dis > target) {
                    right--;
                    while(left<right && nums[right] == nums[right+1]) right--;
                }
                else if(new_dis <target) {
                    left++;
                    while(left<right && nums[left]==nums[left-1]) left++;
                }
                else{
                    return dis;
                }
            }
        }
        return dis;
    }

    public static void main (String[] args) {
        Solution16 solution16 = new Solution16();
        solution16.threeSumClosest(new int[]{-1,0,1,1,55},3);
    }
}
