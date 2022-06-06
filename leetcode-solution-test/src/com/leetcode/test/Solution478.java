package com.leetcode.test;

import java.util.Random;

/**
 * @ClassName: Solution478
 * @Description: Solution leetcode question 478
 * @Author: TIEHAN WANG
 * @Date: 2022/6/5 12:33
 * @Version: v1.0
 */
public class Solution478 {

	private Random random;
	private double x,y,r;
	public Solution478(double radius, double x_center, double y_center) {
		this.random = new Random();
		x = x_center;
		y = y_center;
		r = radius;
	}

	public double[] randPoint() {
		while (true){
			double sx = random.nextDouble()*(2*r)-r;
			double sy = random.nextDouble()*(2*r)-r;
			if(sx*sx+sy*sy <=r*r){
				return new double[]{sx+x,sy+y};
			}
		}
	}

}
