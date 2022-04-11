package com.leetcode.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution804
 * @Description: Solution leetcode question 804
 * @Author: TIEHAN WANG
 * @Date: 2022/4/10 11:03
 * @Version: v1.0
 */
public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        if(words.length == 1) return 1;
        String[] tranfer = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> res = new HashSet<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : word.toCharArray()) {
                stringBuilder.append(tranfer[c-'a']);
            }
            res.add(stringBuilder.toString());
        }
        return res.size();
    }
}
