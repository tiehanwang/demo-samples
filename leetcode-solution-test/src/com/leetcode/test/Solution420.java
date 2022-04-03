package com.leetcode.test;

/**
 * @ClassName: Solution420
 * @Description: Solution leetcode question 420
 * @Author: TIEHAN WANG
 * @Date: 2022/4/2 10:02
 * @Version: v1.0
 */
public class Solution420 {
    public int strongPasswordChecker(String password) {
        int length = password.length();
        char[] chars = password.toCharArray();
        int A = 0,B = 0,C = 0;
        for (char aChar : chars) {
            if(Character.isLowerCase(aChar)) A = 1;
            else if(Character.isDigit(aChar)) B = 1;
            else if(Character.isUpperCase(aChar)) C = 1;
        }
        int categories = A + B + C;
        //<6时 删除没意义连续个数也没有意义 因为小于6插入一个就行 所以应该是需要添加的个数和缺失大小字母数字数的求max值
        if(length < 6){
            return Math.max(6-length,3-categories);
        }
        // 小于20时 增删没意义 只有替换 每三个替换一次 向下取整 和缺失大小字母数字数求最大值
        else if(length <=20){
            int replace = 0;
            for (int i = 0; i < length;) {
                int j = i;
                while (j<length && chars[i] == chars[j]) j++;
                int cnt = j-i;
                if(cnt>=3) replace+= (cnt/3);
                i=j;
            }
            return Math.max(replace,3-categories);
        }
        //大于20 需要使用删除和替换操作 插入没意义因为对应插入删除两次操作
        //优先删除长度大于等于3的连续字符 没删除3个连续字符 等于省了一次替换 cnts代表长度余数为 i 的数量有 x 个
        //删除消耗为base-20 替换消耗为连续个数取整后减去 (base-20) /3 需要注意此时可能串本身缺少大小字母或数字 故还是和取个数max
        else{
            int replace = 0;
            int[] cnts = new int[3];
            for (int i = 0; i < length;) {
                int j = i;
                while (j < length && chars[i] == chars[j])j++;
                int cnt = j-i;
                if(cnt >=3){
                    replace +=(cnt/3);
                    cnts[cnt%3] ++;
                }
                i = j;
            }

            //cur 删除数 replace总需要替换数目
            //对于3n 最先删 3n+1其次 3n+2再次 注意 3n及3n+1删除后要转到3n+2
            //对于3n 只需要删一次 3n+1 删除是两次 3n+2是三次
            //每次循环 用当前的总删除数去减去当前的代价 对于的就是cnts[i] * (i + 1) replace应该只减去cnt[i] 因其不涉及和删除数的代换 只涉及替换
            //在i=2时 此时的replace数目对于的就是剩下所有的3n+2 赋值过去 此时min中 如果cur很大很大 可以代换所有的替代值则 replace为0 即替换总数为0
            //如果cur不够了 那就需要额外替换 则需要max取值
            int base = length -20;
            int cur = base;
            for (int i = 0; i < 3; i++) {
                if(i == 2) cnts[i] = replace;
                if (cnts[i] != 0 && cur != 0) {
                    int t = Math.min(cnts[i] * (i + 1), cur);
                    cur -= t; replace -= t / (i + 1);
                }
            }
            return base+ Math.max(replace,3-categories);
        }
    }

    public static void main (String[] args) {
        Solution420 solution420 = new Solution420();
        System.out.println(solution420.strongPasswordChecker("aaaaaaaAAAAAA6666bbbbaaaaaaABBC"));
    }
}
