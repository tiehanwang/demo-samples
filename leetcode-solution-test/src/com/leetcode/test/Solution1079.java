package com.leetcode.test;

import java.util.Arrays;

/**
 * @ClassName: Solution1079
 * @Description: TODO
 * @Author: TIEHAN WANG
 * @Date: 2023/5/23 21:56
 * @Version: v1.0
 */
public class Solution1079 {
	int count;
	public int numTilePossibilities(String tiles) {
		char[] tilesArray = tiles.toCharArray();
		Arrays.sort(tilesArray);
		back(tilesArray,new boolean[tilesArray.length]);
		return count-1;
	}
	public void back(char[] array,boolean[] used){
		count++;
		for (int i = 0; i < array.length; i++) {
			if (used[i] || (i>0 && array[i] == array[i-1] && !used[i-1])) {
				continue;
			}
			used[i] = true;
			back(array, used);
			used[i] = false;
		}
	}
}
