package com.leetcode.test;

import java.util.HashMap;

/**
 * @ClassName: Solution1
 * @Description: Solution leetcode hot100 question 1
 * @Author: TIEHAN WANG
 * @Date: 2022/3/26 11:26
 * @Version: v1.0
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])){
                int num = hashMap.get(target-nums[i]);
                return new int[]{num,i};
            }else{
                hashMap.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main (String[] args) {
        int[] ints = {2, 7, 11, 15};
        int[] ints1 = {3, 2, 4};
        int[] ints2 = {3,3};
        Solution1 solution1 = new Solution1();
        for (int i : solution1.twoSum(ints, 9)) {
            System.out.println(i);
        }
        for (int i : solution1.twoSum(ints1, 6)) {
            System.out.println(i);
        }
        for (int i : solution1.twoSum(ints2, 6)) {
            System.out.println(i);
        }
    }
}
