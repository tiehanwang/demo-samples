package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution728
 * @Description: Solution leetcode question 728
 * @Author: TIEHAN WANG
 * @Date: 2022/4/1 11:05
 * @Version: v1.0
 */
public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        //暴力模拟解
        //用标签也可更优雅解
        //打表也行
        //时间复杂度O(nlog(right)) n-> right-left+1
        //空间复杂度O(1)
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if(i<10){
                list.add(i);
                continue;
            }
            int res = i;

            while (res!=0){
                int cur = res%10;
                if(cur == 0|| (i%cur != 0)){
                    break;
                }
                res /= 10;
            }
            if(res == 0){
                list.add(i);
            }
        }
        return list;
    }

    public static void main (String[] args) {
        Solution728 solution728 = new Solution728();
        for (Integer integer : solution728.selfDividingNumbers(1, 22)) {
            System.out.println(integer);
        }
        for (Integer integer : solution728.selfDividingNumbers(47, 85)) {
            System.out.println(integer);
        }
    }
}
