package com.leetcode.test;

/**
 * @ClassName: Solution829
 * @Description: Solution leetcode question 829
 * @Author: TIEHAN WANG
 * @Date: 2022/6/3 11:12
 * @Version: v1.0
 */
public class Solution829 {

	//小范围暴力解估计for+while就行了 会爆
	public int consecutiveNumbersSum1(int n) {
		int right = 1;
		int sum = 0;
		int num = 0;
		for (int left = 1; left <= n; left++) {
			while (sum<n){
				sum+=right;
				right++;
			}
			if(sum == n) num++;
			else {
				right--;
				sum -= right;
			}
			sum-=left;
		}
		return num;
	}
	//数论
	//如果对于k个数 k为奇数 n整除k则n可以被k个整数表示 因为k为奇数时整个字段长度可以变成k*? 如果n整除k则可以计算出来
	//如果对于k为偶数 则要考虑2*n 如果k不能被n整除因为被整除时分配不过来 考虑一下偶数时本身被分为n对数 /2对于的是一个带小数点的数
	//如果 k 是偶数，则当 n 不可以被 k 整除且 2n 可以被 k 整除时，正整数 n 可以表示成 k 个连续正整数之和。
	public int consecutiveNumbersSum(int n) {
		int ans = 0;
		int bound = 2 * n;
		for (int k = 1; k * (k + 1) <= bound; k++) {
			if (isKConsecutive(n, k)) {
				ans++;
			}
		}
		return ans;
	}

	public boolean isKConsecutive(int n, int k) {
		if (k % 2 == 1) {
			return n % k == 0;
		} else {
			return n % k != 0 && 2 * n % k == 0;
		}
	}

	public static void main (String[] args) {
		Solution829 solution829 = new Solution829();
		System.out.println(solution829.consecutiveNumbersSum1(15));

	}
}
