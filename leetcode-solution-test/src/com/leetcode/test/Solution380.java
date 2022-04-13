package com.leetcode.test;

import java.util.*;

/**
 * @ClassName: Solution380
 * @Description: Solution leetcode question 387
 * @Author: TIEHAN WANG
 * @Date: 2022/4/13 10:40
 * @Version: v1.0
 */
public class Solution380 {
    static class RandomizedSet {

        HashMap<Integer,Integer> map;
        List<Integer> list;
        Random random;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            int size = list.size();
            map.put(val,size);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            int last = list.get(list.size()-1);
            int index = map.get(val);
            list.set(index,last);
            list.remove(list.size()-1);
            map.put(last,index);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int nextInt = random.nextInt(list.size());
            return list.get(nextInt);
        }
    }

    public static void main (String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
    }
}
