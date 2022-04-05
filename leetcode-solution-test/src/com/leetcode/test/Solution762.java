package com.leetcode.test;

/**
 * @ClassName: Solution762
 * @Description: Solution leetcode question 762
 * @Author: TIEHAN WANG
 * @Date: 2022/4/5 11:31
 * @Version: v1.0
 */
public class Solution762 {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if(isPrime(Integer.bitCount(i))){
                res++;
            }
        }
        return res;
    }
    private boolean isPrime(int x){
        if(x<2){
            return false;
        }
        for (int i = 2; i*i<=x; i++) {
            if(x%i == 0){
                return false;
            }
        }
        return true;
    }
    //right<10^6<2^20
    //所以bitCount()小于20 共有 2 3 5 7 11 13 17 19把对应位都设置为1构建一个二进制数第i位为1代表第i位为质数 和2^(bitCount()) & 不为0则是质数
    public int countPrimeSetBits2(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; ++i) {
            if (((1 << Integer.bitCount(i)) & 665772) != 0) {
                res++;
            }
        }
        return res;
    }
}
