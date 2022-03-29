package com.leetcode.test;

/**
 * @ClassName: Solution9
 * @Description: Solution leetcode question 9
 * @Author: TIEHAN WANG
 * @Date: 2022/3/29 11:16
 * @Version: v1.0
 */
public class Solution9 {
    //反向读一次就行
    public boolean isPalindrome(int x) {
        if(x<0 || x == Integer.MAX_VALUE || (x % 10 == 0 && x != 0)){
            return false;
        }
        int y = 0;
        int other = x;
        while(other!= 0){
            int i = other%10;
            y = y*10+i;
            other /= 10;
        }
        return x == y;
    }
}
