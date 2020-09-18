package main;

/**
 * Create by 孙斌 on 2019/12/4.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode第15题：三数之和
 */
public class LeetCodeArithmetic15 {
    public static void main(String[] args) {
        LeetCodeArithmetic15 leetCodeArithmetic15 = new LeetCodeArithmetic15();
        System.out.println(leetCodeArithmetic15.threeSum(new int[]{2,1,4,3,4,5}));
    }

    /**
     * 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3)
            return result;
        Arrays.sort(nums);//从小到大排序
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) break; //如果i（最小数）大于0那么一定不会等于0 因为后边的数都比它大
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重 将一样的数据去除
            Integer left = i + 1;//左指针
            Integer right = nums.length - 1;//右指针
            while (left < right){
                Integer sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;//去重
                    while (left < right && nums[right] == nums[right - 1]) right--;//去重
                    left++;
                    right--;
                }else if (sum < 0) left++;
                else if (sum > 0) right--;
            }
        }
        return result;
    }
}
