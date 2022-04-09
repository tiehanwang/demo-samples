package com.leetcode.test;

/**
 * @ClassName: Solution780
 * @Description: Solution leetcode question 780
 * @Author: TIEHAN WANG
 * @Date: 2022/4/9 13:57
 * @Version: v1.0
 */
//由于四数正整数 逆推则仅可能是ty,tx中大值减小值 否则出现负数 如果一个个减会超时 取余%较快
//然后结果如果直接得到返回即可否则一个值符合条件 另一个条件继续取余即可
public class Solution780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }
    }
}
