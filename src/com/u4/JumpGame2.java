package com.u4;
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGame2 {

	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		System.out.println(new JumpGame2().jump(nums));
	}
	/**
	 * 时间复杂度太大
	 */
	public int jump(int[] nums) {
        int num = nums.length;
        if(num < 2)
            return 0;
        int[]dp = new int[num];
        dp[num-1] = 0;//num-1 --> num-1 需要0步
        
        for(int i = num-2;i >= 0;i--){//num-2  --> num-1 
            int temp = nums[i];//当前的数
            int minbzs = dp[i+1] + 1;
            for(int j = i+1;j <= i+temp && j < num;j++){
                if(1 + dp[j] < minbzs)
                    minbzs = 1 + dp[j];
            }
            dp[i] = minbzs;
        }
        return dp[0];
    }
	
}
