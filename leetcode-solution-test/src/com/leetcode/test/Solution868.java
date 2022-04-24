package com.leetcode.test;

/**
 * @ClassName: Solution868
 * @Description: Solution leetcode question 868
 * @Author: TIEHAN WANG
 * @Date: 2022/4/24 23:43
 * @Version: v1.0
 */
public class Solution868 {
    public int binaryGap(int n) {
        int left = -1,res = 0;
        for (int i = 0; n != 0; i++) {
            if((n&1) == 1){
                if(left != -1){
                    res = Math.max(res,i-left);
                }
                left = i;
            }
            n >>=1;
        }
        return res;
    }
}
