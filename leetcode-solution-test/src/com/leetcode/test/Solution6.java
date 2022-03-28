package com.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution6
 * @Description: Solution leetcode question 6
 * @Author: TIEHAN WANG
 * @Date: 2022/3/28 11:34
 * @Version: v1.0
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        // 模拟 因不需要返回原有z字形状变化列表 故我们可以直接用list模拟 用StringBuilder亦可
        List<ArrayList<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        if(numRows == 1) return s;
        char[] chars = s.toCharArray();
        int cur = 0;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {

            list.get(cur).add(chars[i]);
            if(cur == 0){
                flag = false;
            }
            if(cur +1 == numRows|| flag){
                flag = true;
                cur--;
                continue;
            }
            cur++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<Character> characters : list) {
            for (Character character : characters) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }
    public String convert1(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) return s;
        StringBuilder stringBuilder = new StringBuilder();
        int time = numRows*2-2;
        for (int i = 0; i < numRows; i++) {
            //i为对于第几行 j为每个周期的起始点 然后寻找相应的点加入
            for (int j = 0; j+i < s.length(); j+=time) {
                //压入当前周期的首字母
                stringBuilder.append(s.charAt(j+i));
                //如果j+time即当前周期的下一个周期起始点 -i是小于s串长度说明当前周期存在两个值 所以应从下一周期起始点往前找i找到当前周期的第二点并压入
                if(i>0 && i< numRows-1 && (j+time-i) < s.length()){
                    stringBuilder.append(s.charAt(j+time-i));
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main (String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.convert1("PAYPALISHIRING", 4));
    }
}
