package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by 孙斌 on 2019/11/5.
 */

/**
 * LeetCode第6题： Z 字形变换
 */
public class LeetCodeArithmetic6 {
    public static void main(String[] args) {
        System.out.println(convert("abcdefjhigk", 4));
    }


    public static String convert(String s, int numRows){
        if(numRows <= 1){
            return s;
        }
        List<StringBuilder> sbs = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(s.length(),numRows); i++){
            sbs.add(new StringBuilder());
        }
        int count = 0;
        boolean bool = false;
        for (char c : s.toCharArray()){
            //判断如果为0 或者 等于 numRows - 1 的情况下 就翻转 为 ++ 或者 -- 这样的话就会完成z字翻转
            //例如 ：当count等于零时就开始++ 当count等于 numRows时就说明已经到最后一个行了，那么就开始 --
            if(count == 0 || count == numRows - 1){
                bool = !bool;
            }
            sbs.get(count).append(c);
            count = bool ? ++count : --count;
        }
        String str = "";
        for (StringBuilder x : sbs) {
            str += x.toString();
        }
        return str;
    }
}
