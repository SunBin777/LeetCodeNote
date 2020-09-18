package main;

/**
 * Create by 孙斌 on 2019/12/4.
 */

/**
 * LeetCode第12题：整数转罗马数字
 */
public class LeetCodeArithmetic12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(123));
        System.out.println(intToRoman(32));
        System.out.println(intToRoman(42));
    }

    /**
     * 整数转罗马数字
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        int[] ints = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strings = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < ints.length ; i++){
            while (num >= ints[i]){
                num -= ints[i];
                result.append(strings[i]);
            }
        }
        return result.toString();
    }

}
