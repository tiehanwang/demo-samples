package com.leetcode.test;

/**
 * @ClassName: Solution479
 * @Description: Solution leetcode question 479
 * @Author: TIEHAN WANG
 * @Date: 2022/4/16 9:51
 * @Version: v1.0
 */
public class Solution479 {
    //n位*n位 求最大回文一定是2n位的
    //从大到小枚举,因为回文先找左部分,然后反转,然后枚举数字从大到小 左部开始枚举 到sqrt(num)为止 因为必然一大一小,大的已经被遍历过.
    public int largestPalindrome(int n) {
        if(n == 1) return 9;
        long max = (long) Math.pow(10,n)-1;
        int res = 0;
        for (long i = max; i > 0 ; i--) {
            long num = i;
            for (long j = num; j>0 ; j/=10) {
                num = num*10+j%10;
            }
            for (long j = max; j*j>num ; j--) {
                if(num%j == 0){
                    res = (int) (num%1337);
                    break;
                }
            }
            if(res!=0) break;
        }
        return res;
    }
}
