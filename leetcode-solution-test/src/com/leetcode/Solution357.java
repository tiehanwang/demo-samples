package com.leetcode;

/**
 * @ClassName: Solution357
 * @Description: Solution leetcode question 357
 * @Author: TIEHAN WANG
 * @Date: 2022/4/11 10:23
 * @Version: v1.0
 */
public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        int res = 10,cur = 9;
        //因为第一位以及算出来有9种后面从9种往后数 有n-1位
        for (int i = 0; i <n-1; i++) {
            cur *= (9-i);
            res+=cur;
        }
        return res;
    }
}
