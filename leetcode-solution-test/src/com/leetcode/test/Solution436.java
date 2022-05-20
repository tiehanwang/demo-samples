package com.leetcode.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Solution436
 * @Description: Solution leetcode question 436
 * @Author: TIEHAN WANG
 * @Date: 2022/5/20 10:05
 * @Version: v1.0
 */
public class Solution436 {
	//每个间隔的起点都 不相同
	public int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		int[][] startIndex = new int[n][2];
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			startIndex[i][0] = intervals[i][0];
			startIndex[i][1] = i;
		}
		Arrays.sort(startIndex, (o1, o2) -> o1[0]-o2[0]);

		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = n-1;
			int target = -1;
			while (left <= right){
				int mid = (left + right)/2;
				if(startIndex[mid][0] >= intervals[i][1]){
					target = startIndex[mid][1];
					right = mid-1;
				}else{
					left = mid+1;
				}
			}
			res[i] = target;
		}
		return res;
	}
}
