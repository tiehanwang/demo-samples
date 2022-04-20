package com.leetcode.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Solution388
 * @Description: Solution leetcode question 388
 * @Author: TIEHAN WANG
 * @Date: 2022/4/20 10:12
 * @Version: v1.0
 */
public class Solution388 {
    public int lengthLongestPath(String input) {
        if (!input.contains(".")) return 0;
        Map<Integer,String> map = new HashMap<>();
        int n = input.length();
        String res = "";
        for (int i = 0; i < n;) {
            int level = 0;
            while(i<n && input.charAt(i)=='\t'){
                level++;
                i++;
            }
            int j = i;
            boolean flag = true;
            while (j<n && input.charAt(j) !='\n'){
                if(input.charAt(j) == '.') flag = false;
                j++;
            }
            String cur = input.substring(i,j);
            String pre = map.getOrDefault(level-1,null);
            String path = pre == null?cur:pre+"/"+cur;
            if(flag) map.put(level,path);
            else if(res.equals("")||path.length()>res.length()){
                res = path;
            }
            i = j+1;
        }
        return res.length();
    }
    public int lengthLongestPath2(String input) {
        if (!input.contains(".")) return 0;
        int n = input.length();
        int[] levelSize = new int[n+1];
        int i = 0;
        int res = 0;
        while (i<n){
            int level = 0;
            while(i<n&&input.charAt(i)=='\t'){
                i++;
                level++;
            }
            int len = 0;
            //是不是目录
            boolean flag = true;
            while (i<n&&input.charAt(i) !='\n'){
                if(input.charAt(i) == '.') flag = false;
                i++;
                len++;
            }
            i++;
            if(level-1 >= 0)len+=levelSize[level-1]+1;
            if(flag) levelSize[level] = len;
            else if(res<len) res = len;
        }
        return res;
    }
}
