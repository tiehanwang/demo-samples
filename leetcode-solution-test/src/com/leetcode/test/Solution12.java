package com.leetcode.test;

/**
 * @ClassName: Solution12
 * @Description: Solution leetcode question 12
 * @Author: TIEHAN WANG
 * @Date: 2022/3/30 14:00
 * @Version: v1.0
 */
public class Solution12 {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
    //字符          数值
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    public String intToRoman2(int num) {
        StringBuffer roman = new StringBuffer();
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strings = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i < 13; i++) {
            while (num>=value[i]){
                num-=value[i];
                roman.append(strings[i]);
            }
        }
        return roman.toString();
    }
}
