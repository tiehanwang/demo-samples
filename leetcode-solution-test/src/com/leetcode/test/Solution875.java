package com.leetcode.test;

/**
 * @ClassName: Solution875
 * @Description: Solution leetcode question 875
 * @Author: TIEHAN WANG
 * @Date: 2022/6/7 14:06
 * @Version: v1.0
 */
public class Solution875 {
	public int minEatingSpeed(int[] piles, int h) {
		int l = 0,r = 0 ;
		for (int pile : piles) {
			r = Math.max(pile,r);
		}
		while (l < r) {
			int mid = l + r >> 1;
			if (check(piles, mid, h)) r = mid;
			else l = mid + 1;
		}
		return r;
	}
	//查看当前速度是否可以满足吃完
	boolean check(int[] p, int k, int h) {
		int ans = 0;
		for (int x : p) ans += Math.ceil(x * 1.0 / k);
		return ans <= h;
	}
}
