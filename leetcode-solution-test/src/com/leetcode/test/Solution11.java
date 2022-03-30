package com.leetcode.test;

/**
 * @ClassName: Solution11
 * @Description: Solution leetcode question 11
 * @Author: TIEHAN WANG
 * @Date: 2022/3/30 14:37
 * @Version: v1.0
 */
public class Solution11 {
    public int maxArea(int[] height) {
        //1.双循环暴力解min(y1,y2)*(x2-x1)取最大值
        //2.双指针暴力 每轮向内移动短板，所有消去的状态都不会导致面积最大值丢失
        int left = 0,right = height.length-1;
        int res = Math.min(height[left],height[right])*(right-left);
        while (left<right){
            if(height[left]<height[right]){
                res = Math.max(res,(right-left)*height[left++]);
            }else{
                res = Math.max(res,(right-left)*height[right--]);
            }
        }
        return res;
    }
}
