package com.leetcode.test;

/**
 * @ClassName: Solution5
 * @Description: Solution leetcode hot100 question 5
 * @Author: TIEHAN WANG
 * @Date: 2022/3/27 10:36
 * @Version: v1.0
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        //动态规划 结果值应为j-i+1
        //l 为长度 分为以下三种情况
        //1.l = 0 即仅一字符时 当然是true是回文
        //2.l == 1 即两字符时 当然回文条件为s[i] == s[j]
        //3.最后一种情况 超过两字符时 回文条件为 dp[i+1][j-1]&&(s[i] == s[j])
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i+l < s.length(); i++) {
                int j = i+l;
                if(l == 0){
                    dp[i][j] = true;
                }else if(l == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{
                    dp[i][j] = dp[i+1][j-1]&& (s.charAt(i) == s.charAt(j));
                }
                //如果dp[i][j]为true意味着为回文 长度为j-i+1或者说是l+1
                //substring到endIndex前一个字符为止 具体可看源码
                if(dp[i][j] && (l+1 > res.length())){
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
