package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by 孙斌 on 2019/11/5.
 */

/**
 * LeetCode第3题：无重复字符的最长子串
 */
public class LeetCodeArithmetic3 {
    public static void main(String[] args){
        String s = "dvasddf";
        System.out.println(lengthOfLongestSubstring(s));
    }
//qwq
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character , Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char maxChar = s.charAt(i);
            if(map.containsKey(maxChar)){
                start = Math.max(map.get(maxChar), start);
            }
            maxLength = Math.max(maxLength , i - start + 1);
            map.put(maxChar, i + 1);
        }
        return maxLength;
    }
}
