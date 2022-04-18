package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution386
 * @Description: Solution leetcode question 386
 * @Author: TIEHAN WANG
 * @Date: 2022/4/18 9:32
 * @Version: v1.0
 */
public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            list.add(num);
            if(num*10<=n){
                num*=10;
            }else{
                while (num%10 == 9||num+1>n)
                    num/=10;
                num++;
            }
        }
        return list;
    }
}
