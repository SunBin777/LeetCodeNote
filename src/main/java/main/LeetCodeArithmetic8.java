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
        System.out.println(myAtoi(" "));
        System.out.println(myAtoi("05a4a5bb6"));
        System.out.println(myAtoi("-   4asd 5456 asd   "));
        System.out.println(myAtoi("5456"));
        System.out.println(myAtoi("05a4a5bb6"));
        System.out.println(myAtoi("05a4a5bb645184546842545"));
        System.out.println(myAtoi("-2147483643"));
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
        //声明i索引变量
        int i = 0;
        //如果str.charAt(i) == 32 （空格) 找到一个不为空格的字符
        while (str.length() > i && str.charAt(i) == 32){
            i++;
        }
        //判断i是否超出索引值
        if(str.length() <= i){
            return 0;
        }
        //声明一个boolean类型的值来判断运算时是正数还是负数
        boolean tr = false;
        //如果为负数也就是  -
        if(str.charAt(i) == 45){
            //将tr设置为true进入为负数的运算
            tr = true;
            // i++ 跳过这个负号（-）
            i++;
            //如果为正数也就是  +
        }else if(str.charAt(i) == 43){
            // i++ 跳过这个加号（+）
            i++;
        }
        //声明结果
        int res = 0;
        //用i循环
        for (;i < str.length();i++) {
            char pop = str.charAt(i);
            //判断是否为数字不是就跳出循环
            if(pop < 48 || pop > 58){
                break;
            }
            //声明一个数字为以后做判断
            int popNumber = Integer.valueOf(pop + "");
            //判断是否大于int最大值也就是    16进制的0x7fffffff    如果大于那么返回最大值
            if(0x7fffffff / 10 < res || (0x7fffffff / 10 == res && popNumber > 7)){
                return 0x7fffffff;
            }
            //判断是否小于int最小值也就是    16进制的0x80000000    如果小于那么返回最小值
            if(0x80000000 / 10 > res || (0x80000000 / 10 == res && popNumber > 8)){
                return 0x80000000;
            }
            //如果是true那么就是负运算    那么将赋予结果(res)的值 变为负数
            if(tr){
                popNumber = -popNumber;
            }
            //最后 将 res乘10 再加上 个位数  例如：“123456” 第一次 1 第二次 1 * 10 + 2 = 12   .... 依次类推
            //          如果是负数           例如：“-123456” 第一次 -1 第二次 -1 * 10 + -2 == -12   .... 依次类推
            res = res * 10 + popNumber;
        }
        return res;
    }
}
