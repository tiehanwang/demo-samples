package com.leetcode.test;

import java.util.*;

/**
 * @ClassName: Solution398
 * @Description: Solution leetcode question 398
 * @Author: TIEHAN WANG
 * @Date: 2022/4/25 12:16
 * @Version: v1.0
 */
public class Solution398 {
//    HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
//    public Solution398(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> orDefault = hashMap.getOrDefault(nums[i], new ArrayList<>());
//            orDefault.add(i);
//            hashMap.put(nums[i],orDefault);
//        }
//    }
//
//    public int pick(int target) {
//        List<Integer> integerList = hashMap.get(target);
//        return integerList.get(new Random().nextInt(integerList.size()));
//    }
    int[] nums;
    Random random;
    public Solution398(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int time = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                time++;
                if(random.nextInt(time) == 0){
                    res = i;
                }
            }
        }
        return res;
    }

}
