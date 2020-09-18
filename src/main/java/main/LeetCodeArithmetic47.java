package main;

/**
 * Create by 孙斌 on 2019/12/4.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode第47题：全排列 II（每日一题）
 */
public class LeetCodeArithmetic47 {
    public static void main(String[] args) {
        LeetCodeArithmetic47 leetCodeArithmetic47 = new LeetCodeArithmetic47();
        System.out.println(leetCodeArithmetic47.permuteUnique(new int[]{121,123,423,123}));
    }

    /** 47
     * 每日一题：全排列 II
     * @param nums
     * @return
     */
    boolean[] booleans;//用于判断是否做过排列

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);//排序
        booleans = new boolean[nums.length];
        insertPermuteUnique(result,nums,list,0);
        return result;
    }

    public void insertPermuteUnique(List<List<Integer>> result,int[] nums,List<Integer> list,int idx){
        if (idx == nums.length) {
            result.add(new ArrayList<>(list));//添加上一次递归时的 list
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if(booleans[i] || (i > 0 && nums[i] == nums[i - 1] && booleans[i - 1]) ){//去重
                continue;
            }
            list.add(nums[i]);
            booleans[i] = true;
            insertPermuteUnique(result,nums,list,idx + 1);
            booleans[i] = false;
            list.remove(idx);
        }
    }
}
