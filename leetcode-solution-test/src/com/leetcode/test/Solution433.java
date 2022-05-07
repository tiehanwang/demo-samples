package com.leetcode.test;

import java.util.*;

/**
 * @ClassName: Solution433
 * @Description: Solution leetcode question 433
 * @Author: TIEHAN WANG
 * @Date: 2022/5/7 10:34
 * @Version: v1.0
 */
//start.length == 8
//end.length == 8
//0 <= bank.length <= 10
//bank[i].length == 8
//start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
public class Solution433 {
	public int minMutation(String start, String end, String[] bank) {
		if(start.equals(end)) return 0;
		Set<String> set = new HashSet<>(Arrays.asList(bank));
		Set<String> visited = new HashSet<>();
		char[] keys = new char[]{'A','C','G','T'};
		Queue<String> queue = new ArrayDeque<>();
		queue.add(start);
		int step = 0;
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String poll = queue.poll();
				for (int j = 0; j < 8; j++) {
					for (int k = 0; k < 4; k++) {
						StringBuffer stringBuffer = new StringBuffer(poll);
						stringBuffer.setCharAt(j,keys[k]);
						if(set.contains(stringBuffer.toString()) && !visited.contains(stringBuffer.toString())){
							if(stringBuffer.toString().equals(end)) return step+1;
							queue.add(stringBuffer.toString());
							visited.add(stringBuffer.toString());
						}
					}
				}
			}
			step++;
		}
		return -1;
	}
}
