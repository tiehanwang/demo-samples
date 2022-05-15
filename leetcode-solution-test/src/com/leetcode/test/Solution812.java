package com.leetcode.test;

/**
 * @ClassName: Solution812
 * @Description: Solution leetcode question 812
 * @Author: TIEHAN WANG
 * @Date: 2022/5/15 15:58
 * @Version: v1.0
 */
public class Solution812 {
	public double largestTriangleArea(int[][] points) {
		int n = points.length;
		double max = -1;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				for (int k = j+1; k < n; k++) {
					max = Math.max(max,execute(points[i][0],points[i][1],points[j][0],points[j][1],points[k][0],points[k][1]));
				}
			}
		}
		return max;
	}
	//计算面积
	private double execute(int x1,int y1,int x2,int y2,int x3,int y3){
		return 0.5*Math.abs(x1*y2+x2*y3+x3*y1-x1*y3-x2*y1-x3*y2);
	}
}
