package com.leetcode.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution228
 * @Description: Solution leetcode question 228
 * @Author: TIEHAN WANG
 * @Date: 2022/5/15 16:14
 * @Version: v1.0
 */
public class Solution228 {
//	public List<String> summaryRanges(int[] nums) {
//		if(nums == null ||nums.length == 0) return null;
//		int n = nums.length;
//		List<String> list = new LinkedList<>();
//		StringBuffer stringBuffer = new StringBuffer();
//		stringBuffer.append(nums[0]);
//		int j = nums[0]+1;
//		for (int i = 1; i < n; i++,j++) {
//			if(j!=nums[i]){
//				if(!stringBuffer.toString().equals(String.valueOf(nums[i-1]))){
//					stringBuffer.append("->");
//					stringBuffer.append(nums[i-1]);
//				}
//				list.add(stringBuffer.toString());
//				stringBuffer.setLength(0);
//				stringBuffer.append(nums[i]);
//				j = nums[i];
//			}
//		}
//		if(stringBuffer.length()!=0){
//			if(!stringBuffer.toString().equals(String.valueOf(nums[n-1]))){
//				stringBuffer.append("->");
//				stringBuffer.append(nums[n-1]);
//			}
//			list.add(stringBuffer.toString());
//			stringBuffer.setLength(0);
//			stringBuffer.append(nums[n-1]);
//		}
//		return list;
//	}
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		int i = 0;
		int n = nums.length;
		StringBuffer temp = new StringBuffer();
		while (i < n) {
			int low = i;
			i++;
			temp.append(Integer.toString(nums[low]));
			while (i < n && nums[i] == nums[i - 1] + 1) {
				i++;
			}
			int high = i - 1;
			if (low < high) {
				temp.append("->");
				temp.append(Integer.toString(nums[high]));
			}
			res.add(temp.toString());
			temp.setLength(0);
		}
		return res;
	}
	public static void main (String[] args) {
		Solution228 solution228 = new Solution228();
		for (String summaryRange : solution228.summaryRanges(new int[]{0,1,2,4,5,7})) {
			System.out.println(summaryRange);
		}
	}
}
