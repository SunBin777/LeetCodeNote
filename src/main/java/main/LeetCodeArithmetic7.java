package main;

/**
 * Create by 孙斌 on 2019/11/5.
 */

/**
 * LeetCode第7题：整数反转
 */
public class LeetCodeArithmetic7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        // 前缀为0x的是16进制
        System.out.println(reverse(0x80000001));
        System.out.println(reverse(-123));
        System.out.println(reverse(654));
        System.out.println(reverse(-654));

        //如果 int类型的最大值 加一就会变成最小值 加二就会变成 最小值+1 依次类推
        int a = Integer.MAX_VALUE + 1;
        int b = Integer.MAX_VALUE + 2;
        int c = Integer.MAX_VALUE + 3;
        int d = Integer.MAX_VALUE;


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        System.out.println(123 << 1);
        System.out.println(123 << 2);


    }

    /**
     *
     * @param x 需要翻转的数字
     * @return  翻转过后的数字
     */
    public static int reverse(int x) {
        // 声明变量
        int res = 0;
        // 循环x 当 x = 0时跳出循环
        while (x != 0){
            // 声明个位数 pop = 每次循环的个位数
            int pop = x % 10;
            // 将 x 除于 10 用做循环的条件   当第一次为 123时 第二次为12 第三次为 1
            x = x / 10;
            //判断是否为最大数  以防溢出
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)){
                return 0;
            }
            //判断是否为最小数  以防溢出
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)){
                return 0;
            }
            // 举例：第二次循环时 将翻转的数字 3 计入 res中乘10 加个位数（pop） 就等于 32
            //       第三次循环时 32 乘 10 等于 320 加个位数（pop） 等于321 成功翻转!!!
            res = res * 10 + pop;
        }
        return res;
    }
}
