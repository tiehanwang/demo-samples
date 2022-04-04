package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Solution307
 * @Description: Solution leetcode question 307
 * @Author: TIEHAN WANG
 * @Date: 2022/4/4 11:37
 * @Version: v1.0
 */
public class Solution307 {
    static class NumArray {
        int[] sum;
        int size;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            size = (int)Math.sqrt(n); //sqrt(n)分组大小
            sum = new int[(n+size-1)/size];//组数 是n/size向上取整数 即n/size + (size-1) /size
            for (int i = 0; i <n; i++) {
                sum[i/size] += nums[i];
            }
        }

        public void update(int index, int val) {
            sum[index/size] +=(val-nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int l_dis = left/size,r_dis = right/size;
            int l_size = left%size;
            int r_size = right%size;
            if(l_dis == r_dis){
                int res = 0;
                for (int i = l_size; i <= r_size; i++) {
                    res +=nums[l_dis*size + i];
                }
                return res;
            }

            int sum1 = 0,sum2 = 0,sum3 = 0;
            for (int i = l_size; i < size ; i++) {
                sum1 += nums[l_dis*size+i];
            }
            for (int i = 0; i <= r_size; i++) {
                sum2 += nums[r_dis*size+i];
            }
            for (int i = l_dis+1; i < r_dis; i++) {
                sum3 += sum[i];
            }
            return sum1+sum2+sum3;
        }
    }

    public static void main (String[] args) {
        NumArray numArray = new NumArray(new int[]{1,3,5});
        numArray.sumRange(0,2);
    }
}