package com.leetcode.test;

/**
 * @ClassName: Solution2024
 * @Description: Solution leetcode question 2024
 * @Author: TIEHAN WANG
 * @Date: 2022/3/29 10:26
 * @Version: v1.0
 */
public class Solution2024 {

    //可转化为求窗口内'F'或'T'个数小于等于k的滑动窗口的最大长度
    //根据两种情况分别求解即可
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxChar(answerKey,'T',k),maxChar(answerKey,'F',k));
    }

    private int maxChar(String answerKey, char target,int time){
        int result = 0;
        for (int left = 0,right = 0,sum = 0; right < answerKey.length(); right++) {
            sum += answerKey.charAt(right) != target ? 1 : 0;
            while (sum > time){
                sum -= answerKey.charAt(left++) !=target ? 1 : 0;
            }
            result = Math.max(result,right-left+1);
        }
        return result;
    }
    public static void main (String[] args) {
        Solution2024 solution2024 = new Solution2024();
        System.out.println(solution2024.maxConsecutiveAnswers("FFFTTFTTFT", 3));
    }
}
