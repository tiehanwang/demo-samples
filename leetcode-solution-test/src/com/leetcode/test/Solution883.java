package com.leetcode.test;

/**
 * @ClassName: Solution883
 * @Description: Solution leetcode question 883
 * @Author: TIEHAN WANG
 * @Date: 2022/4/26 16:21
 * @Version: v1.0
 */
public class Solution883 {
    public int projectionArea(int[][] grid) {
        //xy就是不为0的点的个数,yz分别为对于当前j而言,grid[i][j]的最大值
        //zx也同样如此,zx分别对应当前i而言,grid[i][j]的最大值
        //做两次循环麻烦 因为是n*n可合并
        int xy = 0,yz = 0,zx = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int max = 0;
            int maxYz = 0;
            for (int j = 0; j < n; j++) {
                if(grid[i][j]!=0){
                    xy++;
                }
                maxYz = Math.max(maxYz,grid[j][i]);
                max = Math.max(max,grid[i][j]);
            }
            zx+=max;
            yz+=maxYz;
        }
        return xy+yz+zx;
    }
}
