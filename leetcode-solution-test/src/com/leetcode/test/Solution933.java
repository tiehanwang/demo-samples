package com.leetcode.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Solution933
 * @Description: Solution leetcode question 933
 * @Author: TIEHAN WANG
 * @Date: 2022/5/6 11:01
 * @Version: v1.0
 */
public class Solution933 {
    public static void main (String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(642);
        recentCounter.ping(1849);
        recentCounter.ping(4921);
        recentCounter.ping(5936);
    }
}
class RecentCounter1 {

    int[] time;
    int index;
    public RecentCounter1() {
        time = new int[10000];
        index = 0;
    }
//严格递增
    public int ping(int t) {
        time[index++] = t;
        if(t<=3000){
            return search(t);
        }
        int k = 0;
        for (int i = 0; i < index; i++) {
            if(time[i]>=(t-3000) && time[i] <=t){
                k++;
            }
        }
        return k;
    }
    private int search(int t){
        int k = 0;
        for (int i = 0; i<index && time[i] <= t; i++) {
            k++;
        }
        return k;
    }
}
class RecentCounter{
    Queue<Integer> queue;
    public RecentCounter(){
        queue = new LinkedList<>();
    }
    public int ping(int t){
        queue.add(t);
        while ((t - 3000) > queue.peek()){
            queue.poll();
        }
        return queue.size();
    }
}
