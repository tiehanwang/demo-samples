package com.leetcode.test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName: Solution732
 * @Description: Solution leetcode question 478
 * @Author: TIEHAN WANG
 * @Date: 2022/6/6 21:56
 * @Version: v1.0
 */
public class Solution732 {
}
class MyCalendarThree {

	private TreeMap<Integer, Integer> cnt;

	public MyCalendarThree() {
		cnt = new TreeMap<>();
	}

	//查分数组,每次插入都遍历一次求一次最大值,左区间为正值 右区间为负值,考虑一下.
	public int book(int start, int end) {
		int ans = 0;
		int maxBook = 0;
		cnt.put(start, cnt.getOrDefault(start, 0) + 1);
		cnt.put(end, cnt.getOrDefault(end, 0) - 1);
		for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
			int freq = entry.getValue();
			maxBook += freq;
			ans = Math.max(maxBook, ans);
		}
		return ans;
	}
}