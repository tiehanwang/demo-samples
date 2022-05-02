package com.leetcode.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Solution591
 * @Description: Solution leetcode question 587
 * @Author: TIEHAN WANG
 * @Date: 2022/5/2 9:49
 * @Version: v1.0
 */

//模拟+栈 双指针做不了 因为"<A><A>456</A>  <A> 123  !!  <![CDATA[]]>  123 </A>   <A>123</A></A>"情况 前后双指针不用栈做一一匹配做不了或者说会很麻烦
public class Solution591 {
    public boolean isValid(String code) {
        int n = code.length();
        Deque<String> tags = new ArrayDeque<>();

        int i = 0;
        while (i < n) {
            if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                //如果为结束标签
                if (code.charAt(i + 1) == '/') {
                    //从i开始的第一个>
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    //i是< i+1是/ 要过滤
                    String tagname = code.substring(i + 2, j);
                    if (tags.isEmpty() || !tags.peek().equals(tagname)) {
                        return false;
                    }
                    tags.pop();
                    i = j + 1;
                    //标签为空 且未到达结尾则说明第一个首标签被合并
                    if (tags.isEmpty() && i != n) {
                        return false;
                    }
                    //如果是遇到cdata
                } else if (code.charAt(i + 1) == '!') {
                    if (tags.isEmpty()) {
                        return false;
                    }
                    //<![CDATA[
                    if (i + 9 > n) {
                        return false;
                    }
                    String cdata = code.substring(i + 2, i + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    int j = code.indexOf("]]>", i);
                    if (j < 0) {
                        return false;
                    }
                    i = j + 1;
                    //正常开始标签
                } else {
                    int j = code.indexOf('>', i);
                    if (j < 0) {
                        return false;
                    }
                    String tagname = code.substring(i + 1, j);
                    if (tagname.length() < 1 || tagname.length() > 9) {
                        return false;
                    }
                    for (int k = 0; k < tagname.length(); ++k) {
                        if (!Character.isUpperCase(tagname.charAt(k))) {
                            return false;
                        }
                    }
                    tags.push(tagname);
                    i = j + 1;
                }
                //其他非<字符
            } else {
                if (tags.isEmpty()) {
                    return false;
                }
                ++i;
            }
        }
        return tags.isEmpty();
    }
}
