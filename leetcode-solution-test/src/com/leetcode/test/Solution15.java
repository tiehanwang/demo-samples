package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: Solution15
 * @Description: Solution leetcode question 15
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 8:57
 * @Version: v1.0
 */
public class Solution15 {
    //三数之和 先排序然后双指针 每次的最小数不重复保证了数组不重复 找到和符合条件即插入然后过滤重复值
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        if (nums == null || nums.length <= 2) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0) break;
            if(i>0 && nums[i-1] == nums[i]) continue;
            int left = i+1,right = nums.length-1;
            while (left < right){
                if(nums[i] + nums[left]+nums[right] > 0){
                    right--;
                }else if(nums[i]+ nums[left] + nums[right] < 0){
                    left++;
                }else{
                    list.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) left++;
                    while(left<right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        return list;
    }
}
