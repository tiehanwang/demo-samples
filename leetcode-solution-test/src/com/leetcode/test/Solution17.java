package com.leetcode.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution17
 * @Description: Solution leetcode question 17
 * @Author: TIEHAN WANG
 * @Date: 2022/6/1 15:31
 * @Version: v1.0
 */
public class Solution17 {

	public List<String> letterCombinations(String digits) {
		List<String> list = new LinkedList<>();
		if(digits.length() == 0) return list;
		HashMap<Character,String> map = new HashMap<>(){{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}};
		dfs(list,map,digits,0,new StringBuffer());
		return list;
	}
	private void dfs(List<String> list,HashMap<Character,String> map,String digits,int index,StringBuffer stringBuffer){
		if(index == digits.length()){
			list.add(stringBuffer.toString());
			return;
		}
		char digit = digits.charAt(index);
		String letters = map.get(digit);
		for (int i = 0; i < letters.length(); i++) {
			stringBuffer.append(letters.charAt(i));
			dfs(list,map,digits,index+1,stringBuffer);
			stringBuffer.deleteCharAt(index);
		}
	}
	public static void main (String[] args) {

	}
}
