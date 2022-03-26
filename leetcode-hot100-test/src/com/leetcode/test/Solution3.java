package com.leetcode.test;

import java.util.HashMap;

/**
 * @ClassName: Solution3
 * @Description: Solution leetcode hot100 question 3
 * @Author: TIEHAN WANG
 * @Date: 2022/3/26 11:26
 * @Version: v1.0
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口 用hashmap记录位置

        int max = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if(hashMap.containsKey(chars[i])){
                //left为窗口内第一个不重复的字母 当前字母和之前的字符串出现重复故而将窗口右提到重复字母的下一个 如果已经不覆盖则略过
                left = Math.max(left,hashMap.get(chars[i])+1);
            }
            hashMap.put(chars[i],i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main (String[] args) {
        Solution3 solution3 = new Solution3();
        int abcabcbb = solution3.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }
}
