package com.u10;
/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0
 * @author REN
 *
 */
public class FindMin {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        FindMin fm = new FindMin();
        System.out.println(fm.findMin(arr));
    }
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 3 4 5 1 2
        int base = nums[0];
        int left = 0, right = nums.length-1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left)/2;
            if (nums[mid] - base >= 0) {
                if (nums[mid] < nums[mid+1]) { // 区域一
                    left = mid + 1;
                }else { // 找到了
                    return nums[mid+1];
                }
            }else {
                if (nums[mid-1] < nums[mid]) {
                    right = mid-1;
                }else {
                    return nums[mid];
                }
            }
        }
        return base;
    }
    
}
