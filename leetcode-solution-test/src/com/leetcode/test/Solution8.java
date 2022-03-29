package com.leetcode.test;

/**
 * @ClassName: Solution8
 * @Description: Solution leetcode question 8
 * @Author: TIEHAN WANG
 * @Date: 2022/3/29 11:15
 * @Version: v1.0
 */
public class Solution8 {
    //模拟 注意条件即可
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int flag = 1;

        if(s.equals("")) return 0;
        while (chars[i] == ' '){
            i++;
        }
        if(i == s.length()){
            return 0;
        }
        if(chars[i] == '-'){
            flag = -1;
            i++;
        }else if(chars[i] == '+'){
            i++;
        }

        int result = 0;
        while (i<s.length()){
            if(chars[i] >'9' || chars[i]< '0'){
                break;
            }
            if(result>Integer.MAX_VALUE/10 || ((result == Integer.MAX_VALUE/10) && (chars[i] - '0') > Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }
            if(result<Integer.MIN_VALUE/10 || ((result == Integer.MIN_VALUE/10) && (chars[i]-'0') > -(Integer.MIN_VALUE%10) )){
                return Integer.MIN_VALUE;
            }
            result = result *10 + flag * (chars[i] - '0');
            i++;
        }
        return result;
    }
}
