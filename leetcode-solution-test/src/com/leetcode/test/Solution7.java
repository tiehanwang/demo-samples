package com.leetcode.test;

/**
 * @ClassName: Solution7
 * @Description: Solution leetcode question 7
 * @Author: TIEHAN WANG
 * @Date: 2022/3/28 11:34
 * @Version: v1.0
 */
public class Solution7 {
    public int reverse(int x) {
        int result = 0;
        while (x != 0){
            if (result> Integer.MAX_VALUE/10 || result<Integer.MIN_VALUE/10){
                return 0;
            }
            result *=10;
            int add = x %10;
            result+=add;
            x/=10;
        }
        return result;
    }

    public static void main (String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.reverse(123));
        System.out.println(solution7.reverse(-123));
        System.out.println(solution7.reverse(120));
        System.out.println(solution7.reverse(0));
    }
}
