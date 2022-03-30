package com.leetcode.test;

import java.util.*;

/**
 * @ClassName: Solution1606
 * @Description: Solution leetcode question 1606
 * @Author: TIEHAN WANG
 * @Date: 2022/3/30 13:14
 * @Version: v1.0
 */
public class Solution1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        //k 服务器数量 arrival 到达时间 load[i]第i个请求的执行时间
        //返回最繁忙的服务器序号 定义为一个服务器请求数是所有服务器里最多的
        //就是一致性hash的负载均衡
        //available存空闲节点 优先队列存放正在执行的服务器
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        int[] requests = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for (int i = 0; i < arrival.length; i++) {
            //对于当前到达节点 若有完成执行的放到available里
            while (!busy.isEmpty() && busy.peek()[0]<=arrival[i]){
                available.add(busy.poll()[1]);
            }

            //无空闲机器 舍弃
            if(available.isEmpty()){
                continue;
            }
            //ceiling函数寻找大于等于i%k的机器
            Integer ceiling = available.ceiling(i % k);
            if (ceiling == null){
                ceiling = available.first();
            }
            requests[ceiling] ++;
            busy.add(new int[]{arrival[i]+load[i],ceiling});
            available.remove(ceiling);
        }
        List<Integer> list = new ArrayList<>();
        int asInt = Arrays.stream(requests).max().getAsInt();
        for (int i = 0; i < requests.length; i++) {
            if(requests[i] == asInt){
                list.add(i);
            }
        }
        return list;
    }
}
