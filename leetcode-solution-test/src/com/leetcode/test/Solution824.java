package com.leetcode.test;

/**
 * @ClassName: Solution824
 * @Description: Solution leetcode question 824
 * @Author: TIEHAN WANG
 * @Date: 2022/4/21 10:39
 * @Version: v1.0
 */
public class Solution824 {
    public String toGoatLatin(String sentence) {
        StringBuilder res = new StringBuilder();
        StringBuilder last = new StringBuilder();
        last.append("a");
        int n = sentence.length();
        for (int i = 0; i < n;) {
            int j = i;
            while (j<n && sentence.charAt(j) != ' ') j++;
            if("aeiouAEIOU".indexOf(sentence.charAt(i)) >=0){
                res.append(sentence.substring(i,j)+"ma");
            }else{
                res.append(sentence, i+1, j).append(sentence.charAt(i)).append("ma");
            }
            res.append(last);
            last.append("a");
            i=j+1;
            //非最后一词加空格
            if(i<n) res.append(" ");
        }
        return res.toString();
    }
}
