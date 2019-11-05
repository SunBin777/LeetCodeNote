package main;

/**
 * Create by 孙斌 on 2019/11/5.
 */

/**
 * LeetCode第5题：最长回文字串
 */
public class LeetCodeArithmetic5 {
    public static void main(String[] args){
        String s = "aba";
        System.out.println(longestPalindrome(s));
        String s1 = "acbca";
        System.out.println(longestPalindrome(s1));
        String s2 = "acabcaababd";
        System.out.println(longestPalindrome(s2));
        String s3 = "a";
        System.out.println(longestPalindrome(s3));
    }



    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return "";
        }
        int start = 0;                                      //设置回文起始坐标
        int end = 0;                                        //设置回文结束坐标
        for (int i = 0; i < s.length(); i++){               //循环字符串
            int len1 = test(s, i, i);                       //计算i为中心扩散的最大回文字母数量
            int len2 = test(s, i, i + 1);            //注意：这里是 计算如果有一样的字母例如 bb cc dd accd  这种格式的回文
            int len = Math.max(len1,len2);                  //取最大的回文长度
            if(len > end - start){
                start = i - ((len - 1) >> 1);               //计算坐标开始的区间 2[i]-(3[len]-1)/2
                end = i + (len >> 1);                       //计算坐标结束的区间 2[i]+3[len]/2
            }
        }
        return s.substring(start ,end + 1);
    }

    /**
     * 中心扩展算法
     * 以i为中心字母 展开查询判断 两边第i个字母 的 两边的字母是否相等
     * 例子           s = kaxax   i=2 那么 left = 2 regin = 2
     *
     *   第一次循环 判断是否相等该字符串中的第2个字母和第2个字母是否相等    x == x   结果  true   这时 left - 1 = 1  regin + 1 = 3
     *   这时已经依次扩散了
     *
     *   第二次循环 判断是否相等该字符串中的第1个字母和第3个字母是否相等    a == a   结果  true   这时 left - 1 = 0  regin + 1 = 4
     *   继续扩散
     *
     *   第三次循环 判断是否相等该字符串中的第0个字母和第4个字母是否相等    k == x   结果  false
     *
     *   返回   regin - left - 1   也就是   4 - 0 - 1  = 3
     *
     * @param s
     * @param left
     * @param regin
     * @return
     */
    public static int test(String s,int left,int regin){
        while (left >= 0 && regin < s.length() && s.charAt(left) == s.charAt(regin)){
            left--;                             //左坐标
            regin++;                            //右坐标
        }
        return regin - left - 1;                //右坐标  减去  左坐标  再减去 1 等于  返回数字的区间
    }
}
