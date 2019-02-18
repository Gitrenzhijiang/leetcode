package com.u10;

import java.util.Arrays;


/*
    给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

如果数组元素个数小于 2，则返回 0。

示例 1:

输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
示例 2:

输入: [10]
输出: 0
解释: 数组元素个数小于 2，因此返回 0。
说明:

你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */
public class MaximumGap {

    public static void main(String[] args) {
        MaximumGap mg = new MaximumGap();
        // 522  712 1032    1032    4112
        int[] nums = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740}; 
        mg.radixSort(nums);
        
        int[] nums2 = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740}; 
        Arrays.sort(nums2);
        
        int[] nums3 = {-15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740}; 
        for (int i = 0;i < nums.length;i++) {
            System.out.print(nums2[i] + "\t");
        }
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != nums2[i]) {
                System.out.println("排序出错。");
                break;
            }
        }
        System.out.println(mg.maximumGap(nums3));
    }
    public int maximumGap(int[] nums) {
        
        if (nums.length <= 1) {
            return 0;
        }
        radixSort(nums);
        //Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
        
        int max = Math.abs(nums[0] - nums[1]);
        //排好序之后
        for (int i = 0;i < nums.length-1;i++) {
            max = Math.max(max, Math.abs(nums[i]-nums[i+1]));
        }
        
        return max;
    }
    /**
     * 基数排序, 数组元素必须非负
     * @param nums
     */
    public void radixSort(int[] nums) {
        // 把int的每8位看作 一个数
        // 先按照 第0-7位排序，然后8-15, 16-23, 24-31
        for (int i = 0;i < 4;i++) {
            countSort(nums, i);
        }
    }
    // 计数排序
    protected void countSort(int[] nums, int base) {
        int[] ret = new int[nums.length];
        int c[] = new int[256]; // 7F
        // 此时,我们将c[i] = 定义成i元素出现的次数
        for (int i = 0;i < nums.length;i++) {
            c[size(nums[i], base)] = c[size(nums[i], base)] + 1;
        }
        // 接下来, 将c[i]累计为i应该在排序好的数组的位置
        for (int i = 1;i < c.length;i++) {
            c[i] += c[i-1]; // 5 5 5     0 0 4 4
        }
        for (int i = nums.length-1;i >= 0;i--) {
            ret[--c[size(nums[i], base)]] = nums[i];
        }
        System.arraycopy(ret, 0, nums, 0, ret.length);
    }
    protected int size(int n, int base) {
        n = n >>> (8*base);
        return n & 0x000000FF;
    }
}
