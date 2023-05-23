package com.leetcode.test;

/**
 * @ClassName: Solution2432
 * @Description: TODO
 * @Author: TIEHAN WANG
 * @Date: 2023/5/23 21:56
 * @Version: v1.0
 */
public class Solution2432 {
	public int hardestWorker(int n, int[][] logs) {
		int usedTime = 0;
		int currentTime = 0;
		int personId = Integer.MAX_VALUE;
		for (int i = 0; i < logs.length; i++) {
			//完成时间-当前时间
			int time = logs[i][1]-currentTime;
			currentTime = logs[i][1];
			if(time > usedTime || (time == usedTime && personId >= logs[i][0])){
				personId = logs[i][0];
				usedTime = time;
			}
		}
		return personId;
	}
}
