package com.leetcode.test;

/**
 * @ClassName: Solution796
 * @Description: Solution leetcode question 796
 * @Author: TIEHAN WANG
 * @Date: 2022/4/7 9:30
 * @Version: v1.0
 */
public class Solution796 {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }
}
