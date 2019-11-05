package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by 孙斌 on 2019/11/5.
 */

/**
 * LeetCode第1题：两数之和
 */
public class LeetCodeArithmetic1 {

    public static void main(String[] args){
        int[] nums = new int[5];
        nums[0] = 5;
        nums[1] = 17;
        nums[2] = 24;
        nums[3] = 68;
        nums[4] = 94;
        int target = 22;
        int[] result = twoSum(nums,target);
        System.out.println(System.currentTimeMillis());
        System.out.println(result[0] + "  " + result[1]);
        System.out.println(System.currentTimeMillis());
    }
    /**
     * nums数组【2,5,7,6】 ,      target总合       要求：算出两个相加数的下标
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            result[0] = target - nums[i];
            if(map.containsKey(result[0])){
                result[0] = map.get(result[0]);
                result[1] = i;
                return result;
            }
            map.put( nums[i],i);
        }
        return result;
    }
}
