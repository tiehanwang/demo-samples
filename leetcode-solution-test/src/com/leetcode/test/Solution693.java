package com.leetcode.test;

/**
 * @ClassName: Solution693
 * @Description: Solution leetcode question 693
 * @Author: TIEHAN WANG
 * @Date: 2022/3/28 11:34
 * @Version: v1.0
 */
public class Solution693 {

    public boolean hasAlternatingBits(int n) {
        int pre = 2,cur = 0;
        while (n!=0){
            //余数为当前二进制位的值
            cur = n%2;
            if(cur == pre){
                return false;
            }
            pre = cur;
            n /= 2;
        }
        return true;
    }
    public boolean hasAlternatingBits2(int n) {
        int base = 1;
        int m = n;
        int mBase = 2;
        while(n>0 && m >0){
            n-=base;
            m-=mBase;
            mBase = mBase *4;
            base = base *4;
        }
        return n == 0 || m == 0;
    }
    public boolean hasAlternatingBits3(int n) {
        //1010 0101 a = 1111 & a+1 00000 == 0 注意不能直接返回 (n^(n+1))  == 0 因为存在类似于100情况
        int a = n^(n>>1);
        return (a&(a+1)) == 0;
    }

}
