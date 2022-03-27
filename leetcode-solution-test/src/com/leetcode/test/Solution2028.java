package com.leetcode.test;

/**
 * @ClassName: Solution2028
 * @Description: leetcode 2028 Solution
 * @Author: TIEHAN WANG
 * @Date: 2022/3/27 10:35
 * @Version: v1.0
 */
public class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        //模拟
        //m次投为rolls 而mean则为平均值 总值为mean * (rolls.length+n)
        //有了n总值sum
        //sum平均分配一下 然后剩余值一次增加防止溢出即可
        //求解是否有一组符合答案
        int sum = mean * (rolls.length +n);
        for (int i = 0; i < rolls.length; i++) {
            sum-=rolls[i];
        }
        int[] result = new int[n];
        if(sum<n || sum >6*n){
            return new int[0];
        }
        int base = sum/n;
        int other = sum - base*n;
        for (int i = 0; i < result.length; i++) {
            if(other > 0)
            {
                result[i] = base +1;
                other--;
            }
            else{
                result[i] = base;
            }
        }
        return result;
    }
}
