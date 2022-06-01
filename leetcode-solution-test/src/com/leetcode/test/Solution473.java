package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution473
 * @Description: Solution leetcode question 473
 * @Author: TIEHAN WANG
 * @Date: 2022/6/1 14:56
 * @Version: v1.0
 */
public class Solution473 {
	public boolean makesquare(int[] matchsticks) {
		int sum = 0;
		Arrays.sort(matchsticks);
		for (int matchstick : matchsticks) {
			sum+=matchstick;
		}
		if(sum %4 != 0 ) return false;
		for (int i = matchsticks.length - 1,j=0; j<i; i--,j++) {
			int temp = matchsticks[i];
			matchsticks[i] = matchsticks[j];
			matchsticks[j] = temp;
		}
		int[] edges = new int[4];
		return dfs(0,edges,matchsticks,sum/4);
	}
	private boolean dfs(int index,int[] edges,int[] matchsticks,int len){
		if(index == matchsticks.length){
			return true;
		}
		for (int i = 0; i < edges.length; i++) {
			edges[i]+=matchsticks[index];
			if(edges[i]<=len && dfs(index+1,edges,matchsticks,len)){
				return true;
			}
			edges[i]-=matchsticks[index];
		}
		return false;
	}
	public static void main (String[] args) {
		Solution473 solution473 = new Solution473();
		solution473.makesquare(new int[]{1,1,2,2,2});
	}
}
