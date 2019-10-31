package com.xzj;

import java.util.Arrays;

/**
 * Create by xuzhijun.online on 2019/10/31.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }


    /**
     * 时间复杂度O(n^2)
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        //参数检查
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
