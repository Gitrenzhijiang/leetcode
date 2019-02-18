package com.u10;
/*
峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞。

示例 1:

输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
示例 2:

输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5 
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
 */
public class FinkPeakElement {

    public static void main(String[] args) {
        
    }
    public int findPeakElement(int[] nums) {
        // 第一种算法
//        for (int i = 0;i < nums.length;i++) {
//            if (!istest(nums, i-1, i) && istest(nums, i, i+1)) {
//                return i;
//            }
//        }
//        return -1;
        // 现在我们考虑它的第一个峰值很可能不在开头处，而是偏向与中间
        /**
         * 由于题目中提示了要用对数级的时间复杂度，
         * 那么我们就要考虑使用类似于二分查找法来缩短时间，
         * 由于只是需要找到任意一个峰值，那么我们在确定二分查找折半后中间那个元素后，
         * 和紧跟的那个元素比较下大小，如果大于，则说明峰值在前面，如果小于则在后面。
         * 这样就可以找到一个峰值了，代码如下：
         */
        // 从前往后,找到下降的
        int left = 0, right = nums.length - 1;
        
        int mid = 0;
        while (left < right) {
            mid = left + (right - left)/2;
            // 只需要找到下降的
            if (nums[mid] > nums[mid+1]) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    
    // 如果nums[i] > nums[j]; 则返回1,否则返回0(i < j) 
    public boolean istest(int[] nums, int i, int j) {
        if (i == -1) {
            return false;
        }else if (j == nums.length) {
            return true;
        }else if (nums[i] > nums[j]) {
            return true;
        }
        return false;
    }
    
}



