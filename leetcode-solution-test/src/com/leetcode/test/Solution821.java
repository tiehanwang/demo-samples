package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution821
 * @Description: Solution leetcode question 821
 * @Author: TIEHAN WANG
 * @Date: 2022/4/19 10:43
 * @Version: v1.0
 */
public class Solution821 {

    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        int[] result = new int[s.length()];
        Arrays.fill(result, Integer.MAX_VALUE);
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]== c){
                result[i] = 0;
                for (int j = 0; j < chars.length; j++) {
                    result[j] = Math.min(result[j],Math.abs(i-j));
                }
            }
        }
        return result;
    }
    public int[] shortestToChar2(String s, char c) {
        char[] chars = s.toCharArray();
        int[] result = new int[s.length()];
        int n = chars.length;
        int index = -n;
        for (int i = 0; i < n; i++) {
            if(chars[i] == c){
                index = i;
            }
            result[i] = i-index;
        }
        index = 2*n;
        for (int i = chars.length - 1; i >= 0; i--) {
            if(chars[i] ==c){
                index = i;
            }
            result[i] = Math.max(index-i,result[i]);
        }
        return result;
    }
}
