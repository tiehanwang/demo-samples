package com.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Solution14
 * @Description: Solution leetcode question 14
 * @Author: TIEHAN WANG
 * @Date: 2022/4/2 10:02
 * @Version: v1.0
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        //sort;
        Arrays.sort(strs);
        int max = 0;
        if(strs.length==1) return strs[0];
        String common = findCommon(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            common = findCommon(common, strs[i]);
        }
        return common;
    }
    public String findCommon(String cur,String next){
        int i = 0,j = 0;

        for (; i < cur.length() && j<next.length(); i++,j++) {
            if(cur.charAt(i) != next.charAt(j)){
                return cur.substring(0,i);
            }
        }
        if(i == cur.length()){
            return cur;
        }
        return next;
    }
}
