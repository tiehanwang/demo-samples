package com.leetcode.test;

/**
 * @ClassName: Solution744
 * @Description: Solution leetcode question 744
 * @Author: TIEHAN WANG
 * @Date: 2022/4/3 8:57
 * @Version: v1.0
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if(target >= letters[length-1] || target < letters[0]){
            return letters[0];
        }
        for (int i = 0; i < length; i++) {
            if(letters[i] > target){
                return letters[i];
            }
        }
        return letters[0];
    }
    public char nextGreatestLetter1(char[] letters, char target){
        int length = letters.length;
        if(target >= letters[length-1] || target < letters[0]){
            return letters[0];
        }
        int left = 0,right = length-1;
        while (left < right){
            int mid = (right-left)/2+left;
            if(letters[mid] <= target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return letters[left];
    }
}
