package com.u10;
/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * @author REN
 * 
 */
public class MaxMutipleSubSeque {

    public static void main(String[] args) {
        int []nums = {2, -5, -2, -4, 3};
        MaxMutipleSubSeque mm = new MaxMutipleSubSeque();
        System.out.println(mm.maxProduct(nums));
    }
    /**
     * 当然， 有一些dp, 不可能一步到位求到结果， 这时就应该考虑 局部问题， 固定化问题，
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int []max = new int[nums.length];// max[i] 从0到i最大子数数组乘积
        int []min = new int[nums.length];
        // 我们可能遇到 0 3 -2
        max[0] = min[0] = nums[0];
        int ret = max[0];
        for (int i = 1;i < nums.length;i++) {
            int c1 = max[i-1] * nums[i];
            int c2 = min[i-1] * nums[i];
            max[i] = Math.max(Math.max(c1, c2), nums[i]);
            min[i] = Math.min(Math.min(c1, c2), nums[i]);
            ret = max[i] > ret?max[i]:ret;
        }
        return ret;
    }
}





