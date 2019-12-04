package main;

/**
 * Create by 孙斌 on 2019/12/4.
 */

/**
 * LeetCode第9题：回文数
 */
public class LeetCodeArithmetic9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(4121));
        System.out.println(isPalindrome(1214));
        System.out.println(isPalindrome(0x7fffffff));
    }

    public static boolean isPalindrome(int x) {
        //x < 0时第一个为符号表示符，所以直接返回false    (x % 10 == 0 && x != 0) 如果x!=0 且最后一位等于0时，为不相等，因为第一位不会为0
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        //声明变量resultNumber用于接受翻转的数字，xNumber用于做反转时除的数
        int resultNumber = 0,xNumber = x;
        while (0 < xNumber){
            //                                                      resultNumber              xNumber                结果
            //将resultNumber *10 加上 xNumber的个位数 例子：第一次：    0*10=0       +      121 % 10 =1                1
            //                                              第二次      1*10=10      +       12 % 10 =2                12
            //                                              第三次      12*10=120    +        1 % 10 =1                121
            resultNumber = resultNumber * 10 + xNumber % 10;
            xNumber /= 10;
        }
        //返回结果
        return resultNumber == x;
    }
}
