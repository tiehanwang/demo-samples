package com.leetcode.test;

/**
 * @ClassName: Solution17_11
 * @Description: Solution leetcode question 17-11
 * @Author: TIEHAN WANG
 * @Date: 2022/5/27 13:29
 * @Version: v1.0
 */
public class Solution17_11 {
	public int findClosest(String[] words, String word1, String word2) {
		int x = -1;
		int y = -1;
		int dis = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if(words[i].equals(word1)){
				x = i;
				if(y>=0){
					dis = Math.min(dis,Math.abs(x-y));
				}
			}else if(words[i].equals(word2)){
				y = i;
				if(x>=0){
					dis = Math.min(dis,Math.abs(x-y));
				}
			}
		}
		return dis;
	}
}
