package com.leetcode.test;

import java.util.HashMap;

/**
 * @ClassName: Solution13
 * @Description: Solution leetcode question 13
 * @Author: TIEHAN WANG
 * @Date: 2022/4/2 10:02
 * @Version: v1.0
 */
public class Solution13 {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return hashMap.getOrDefault(s.charAt(0),0);
        }
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i<chars.length-1 && hashMap.get(chars[i])<hashMap.get(chars[i+1])){
                res-=hashMap.get(chars[i]);
            }else{
                res+=hashMap.get(chars[i]);
            }
        }
        return res;
    }

    public static void main (String[] args) {
        Solution13 solution13 = new Solution13();
        int iii = solution13.romanToInt("III");
        System.out.println(iii);
    }
}
