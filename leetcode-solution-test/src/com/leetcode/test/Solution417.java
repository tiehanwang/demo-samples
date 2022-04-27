package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution417
 * @Description: Solution leetcode question 417
 * @Author: TIEHAN WANG
 * @Date: 2022/4/27 9:43
 * @Version: v1.0
 */
public class Solution417 {
    int[][] dis = {{0,1},{0,-1},{1,0},{-1,0}};
    int m = 0;
    int n = 0;
    int[][]heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i,0,pacific);
        }
        for (int i = 0; i < n; i++) {
            dfs(0,i,pacific);
        }
        for (int i = 0; i < m; i++) {
            dfs(i,n-1,atlantic);
        }
        for (int i = 0; i < n-1; i++) {
            dfs(m-1,i,atlantic);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    list.add(res);
                }
            }
        }
        return list;
    }
    public void dfs(int x,int y,boolean[][]visited){
        if(visited[x][y]){
            return;
        }
        visited[x][y] = true;
        for (int[] ints : dis) {
            int newX = x+ints[0];
            int newY = y+ints[1];
            if(newX>=0 && newX<m && newY>=0 && newY<n &&heights[newX][newY]>=heights[x][y]){
                dfs(newX,newY,visited);
            }
        }
    }

    public static void main (String[] args) {
        Solution417 solution417 = new Solution417();
        solution417.pacificAtlantic(new int[][]{{1,2,2,3,5}, {3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
    }
}
