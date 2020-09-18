package main;

/**
 * Create by 孙斌 on 2019/12/4.
 */

/**
 * LeetCode第13题：罗马数字转整数
 */
public class LeetCodeArithmetic13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMIVI"));
    }


    /**13
     * 罗马数字转整数
     * @return
     */
    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length() ; i++){
            if(s.length() > i + 1 && getVal(s.substring(i,i+2)) != 0) {
                result += getVal(s.substring(i,i+2)) == 0 ? 0 : getVal(s.substring(i,i+2));
                i += 1;
            }else {
                result += getVal(s.substring(i,i+1));
            }
        }
        return result;
    }

    public static int getVal(String str){
        switch (str){
            case "I":
                return 1;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "IX":
                return 9;
            case "X":
                return 10;
            case "XL":
                return 40;
            case "L":
                return 50;
            case "XC":
                return 90;
            case "C":
                return 100;
            case "CD":
                return 400;
            case "D":
                return 500;
            case "CM":
                return 900;
            case "M":
                return 1000;
            default:
                return 0;
        }
    }
}
