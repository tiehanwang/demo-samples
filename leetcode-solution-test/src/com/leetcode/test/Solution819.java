package com.leetcode.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName: Solution819
 * @Description: Solution leetcode question 819
 * @Author: TIEHAN WANG
 * @Date: 2022/4/17 10:58
 * @Version: v1.0
 */
public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(banned));
        char[] chars = paragraph.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            //!?',;.
            if(chars[i] == ' ' || chars[i] == ','|| chars[i] == '!' || chars[i] == '?' ||chars[i] == '\'' || chars[i]=='.'|| chars[i] == ';'){
                if(stringBuilder.toString().equals("") ||stringBuilder.length() == 0) continue;
                hashMap.put(stringBuilder.toString(),hashMap.getOrDefault(stringBuilder.toString(),0)+1);
                stringBuilder.setLength(0);
//                stringBuilder.delete(0,stringBuilder.length());
//                stringBuilder.replace(0,stringBuilder.length(),"");
                continue;
            }
            stringBuilder.append(Character.toLowerCase(chars[i]));
        }
        int max = 0;
        String x = "";
        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            if(hashSet.contains(stringIntegerEntry.getKey())) continue;
            if(stringIntegerEntry.getValue()>max){
                max = stringIntegerEntry.getValue();
                x = stringIntegerEntry.getKey();
            }
        }
        return x;
    }
    public String mostCommonWord2(String paragraph, String[] banned) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(banned));
        char[] chars = paragraph.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int max = 0;
        for (int i = 0; i <= chars.length; i++) {
            //!?',;.
            if(i<chars.length && Character.isLetter(chars[i])){
                stringBuilder.append(Character.toLowerCase(chars[i]));
            }else if(stringBuilder.length()>0){
                if(hashSet.contains(stringBuilder.toString())){
                    stringBuilder.setLength(0);
                    continue;
                }
                int cur = hashMap.getOrDefault(stringBuilder.toString(),0)+1;
                max = Math.max(cur,max);
                hashMap.put(stringBuilder.toString(),cur);
                stringBuilder.setLength(0);
            }
        }
        String x = "";
        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            if(stringIntegerEntry.getValue()==max){
                return stringIntegerEntry.getKey();
            }
        }
        return x;
    }
    public static void main (String[] args) {
        Solution819 solution819 = new Solution819();
        System.out.println(solution819.mostCommonWord2("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
    }
}
