package main;

/**
 * Create by 孙斌 on 2019/11/6.
 */

/**
 * LeetCode第8题：字符串转换整数 (atoi)
 */
public class LeetCodeArithmetic8 {

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        myAtoi("   4asd 5456 asd   ");
        myAtoi("5456");
        myAtoi("05a4a5bb6");
        myAtoi("05a4a5bb645184546842545");
        myAtoi("-2147483649");
        myAtoi("2147483649");
    }


    /**
     * 筛选出数字 将字母和空格过滤
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //过滤为空的字符串
        if(str == null || str.length() <= 0){
            return 0;
        }
        int res = 0;
        for (int i = 0;i < str.length();i++) {
            i = nexsNumber(i, str);
            char pop = str.charAt(i);
            //判断是否为数字不是就跳出循环
            if(pop < 49 || pop > 57){
                continue;
            }
            if(0x7fffffff / 10 < res || (0x7fffffff / 10 == res && Integer.valueOf(pop) > 7)){
                return 0x7fffffff;
            }
            if(0x80000000 / 10 > res || (0x80000000 / 10 == res && Integer.valueOf(pop) <= 8)){
                return 0x80000000;
            }
            res = res * 10 + Integer.valueOf(pop);
        }
        return res;
    }

    public static int nexsNumber(int start,String str){
        while (str.charAt(start) == ' '){
            start++;
        }
        return start;
    }

}
