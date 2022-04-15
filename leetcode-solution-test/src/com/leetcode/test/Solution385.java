package com.leetcode.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution385
 * @Description: Solution leetcode question 385
 * @Author: TIEHAN WANG
 * @Date: 2022/4/15 10:13
 * @Version: v1.0
 */
public class Solution385 {
    public static class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger(){}

    // Constructor initializes a single integer.
    public NestedInteger(int value){}

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){return true;}

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){return 1;}

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){return null;}
}
    static NestedInteger target = new NestedInteger(0);

    public NestedInteger deserialize(String s) {
        if(s.charAt(0)!='[') return new NestedInteger(Integer.parseInt(s));

        Deque<NestedInteger> deque = new LinkedList<>();
        int length = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            if(chars[i] == ','){
                continue;
            }else if(chars[i] == '-'||chars[i]>='0' && chars[i]<='9'){
                int j = i;
                int flag = 1;
                if(chars[i] == '-'){
                    j = i+1;
                    flag = -1;
                }
                int num = 0;
                while (j>0 && (chars[j]>='0' && chars[j]<='9')){
                    num = num*10 + (chars[j]-'0');
                    j++;
                }
                deque.addLast(new NestedInteger(num*flag));
                i = j-1;
            }else if(chars[i] == '['){
                deque.addLast(new NestedInteger());
                deque.addLast(target);
            }else{
                List<NestedInteger> list = new ArrayList<>();
                NestedInteger nestedInteger = new NestedInteger();
                while (!deque.isEmpty()){
                    NestedInteger poll = deque.pollLast();
                    if(poll == target){
                        break;
                    }
                    list.add(poll);
                }
                for (int j = list.size()-1; j >=0; j--) {
                    deque.peekLast().add(list.get(i));
                }
            }
        }
        return deque.peekLast();
    }

    public static void main (String[] args) {
        Solution385  solution385 = new Solution385();
        solution385.deserialize("[123,[456,[789]]]");
    }
}
