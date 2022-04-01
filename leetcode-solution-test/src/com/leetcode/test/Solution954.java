package com.leetcode.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @ClassName: Solution954
 * @Description: Solution leetcode question 954
 * @Author: TIEHAN WANG
 * @Date: 2022/4/1 10:35
 * @Version: v1.0
 */
public class Solution954 {
    //hash存相关次数
    //list保留keySet() 即arr不重复值
    //对list按绝对值排序 对于每个绝对值小的数 他在hashmap中一定存在 对于2*integer的个数一定要大于等于integer的个数 否则为false
    //仅对2*integer进行扣减即可
    //时间复杂度O(nlogn)
    //空间复杂度O(n+m) n为arr.length m为arr值域
    public boolean canReorderDoubled(int[] arr) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int j : arr) {
            hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
        }
        if (hashMap.getOrDefault(0,0)%2 != 0){
            return false;
        }

        ArrayList<Integer> list = new ArrayList<>(hashMap.keySet());
        list.sort((a, b) -> Math.abs(a) - Math.abs(b));
        for (Integer integer : list) {
            if(hashMap.getOrDefault(integer*2,0)<hashMap.get(integer)){
                return false;
            }
            hashMap.put(integer*2,hashMap.getOrDefault(integer*2,0)-hashMap.get(integer));
        }
        return true;
    }

}
