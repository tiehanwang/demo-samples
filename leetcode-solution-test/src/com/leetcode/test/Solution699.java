package com.leetcode.test;

import java.util.*;

/**
 * @ClassName: Solution699
 * @Description: Solution leetcode question 699
 * @Author: TIEHAN WANG
 * @Date: 2022/5/26 12:49
 * @Version: v1.0
 */
public class Solution699 {
	//其中 positions[i] = [lefti, sideLengthi] 表示：第 i 个方块边长为 sideLengthi ，其左侧边与 x 轴上坐标点lefti 对齐。
	//lefti不保证递增
	//

	public List<Integer> fallingSquares1(int[][] positions){
		int n = positions.length;
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int height = positions[i][1];
			//如果不碰撞时坐标区间
			int left = positions[i][0],right = positions[i][0]+positions[i][1];
			for (int j = 0; j < i; j++) {
				//之前落下的块的底部区间
				int newLeft = positions[j][0],newRight = positions[j][0]+positions[j][1];
				//贴边不行
				if(right > newLeft && left < newRight){
					height = Math.max(height,list.get(j)+positions[i][1]);
				}
			}
			list.add(height);
		}
		for (int i = 1; i < n; i++) {
			list.set(i, Math.max(list.get(i), list.get(i - 1)));
		}
		return list;
	}
	//
	public List<Integer> fallingSquares(int[][] positions) {
		int n = positions.length;
		List<Integer> ret = new ArrayList<>();
		TreeMap<Integer, Integer> heightMap = new TreeMap<>();
		heightMap.put(0, 0); // 初始时从 0 开始的所有点的堆叠高度都是 0
		for (int i = 0; i < n; i++) {
			int size = positions[i][1];
			int left = positions[i][0], right = positions[i][0] + positions[i][1] - 1;
			Integer lp = heightMap.higherKey(left), rp = heightMap.higherKey(right);
			Integer prevRightKey = rp != null ? heightMap.lowerKey(rp) : heightMap.lastKey();
			int rHeight = prevRightKey != null ? heightMap.get(prevRightKey) : 0; // 记录 right + 1 对应的堆叠高度（如果 right + 1 不在 heightMap 中）

			// 更新第 i 个掉落的方块的堆叠高度
			int height = 0;
			Integer prevLeftKey = lp != null ? heightMap.lowerKey(lp) : heightMap.lastKey();
			Map<Integer, Integer> tail = prevLeftKey != null ? heightMap.tailMap(prevLeftKey) : heightMap;
			for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
				if (entry.getKey().equals(rp)) {
					break;
				}
				height = Math.max(height, entry.getValue() + size);
			}

			// 清除 heightMap 中位于 (left, right] 内的点
			Set<Integer> keySet = new TreeSet<>(tail.keySet());
			for (Integer tmp : keySet) {
				if (lp == null || tmp < lp) {
					continue;
				}
				if (rp != null && tmp >= rp) {
					break;
				}
				heightMap.remove(tmp);
			}

			heightMap.put(left, height); // 更新 left 的变化
			if (rp == null || rp != right + 1) { // 如果 right + 1 不在 heightMap 中，更新 right + 1 的变化
				heightMap.put(right + 1, rHeight);
			}
			ret.add(i > 0 ? Math.max(ret.get(i - 1), height) : height);
		}
		return ret;
	}

}
