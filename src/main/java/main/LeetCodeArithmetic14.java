package main;

/**
 * Create by 孙斌 on 2019/12/4.
 */

/**
 * LeetCode第14题：最长公共前缀
 */
public class LeetCodeArithmetic14 {
    public static void main(String[] args) {
        LeetCodeArithmetic14 leetCodeArithmetic14 = new LeetCodeArithmetic14();
        System.out.println(leetCodeArithmetic14.longestCommonPrefix(new String[]{"faws","faxs"}));
    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1){
            return "";
        }
        String result = strs[0];
        for (int i = 0; i < strs.length; i++){
            if(strs != null && (result.length() > strs[i].length())){
                result = strs[i];
            }
        }
        for (int i = 0; i < strs.length; ){
            String str = strs[i].substring(0,result.length());
            if (!result.equals(str)){
                result = result.substring(0,result.length()-1);
                i = 0;
            }else
                ++i;
        }
        return result;
    }

}
