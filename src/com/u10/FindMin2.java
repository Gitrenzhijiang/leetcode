package com.u10;

public class FindMin2 {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(new FindMin2().findMin(nums, 0, nums.length-1));
        System.out.println(new FindMin2().findMin(nums));
    }
    public int findMin(int[] nums, int l, int r) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = l, right = r, mid = 0;
        int base = nums[l];
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > base) {
                if (nums[mid] > nums[mid+1]) {
                    return nums[mid+1];
                }else {
                    left = mid + 1;
                }
            }else if (nums[mid] < base){
                // 小于基准
                if (nums[mid-1] > nums[mid]) {
                    return nums[mid];
                }else {
                    right = mid - 1;
                }
            }else {
                // 等于基准, 在left, mid-1; mid ; mid+1, right选出最小
                Integer r1 = null;
                if (left <= mid-1) {
                     r1 = findMin(nums, left, mid - 1);
                }
                Integer r2 = null;
                if (mid + 1 <= right) {
                    r2 = findMin(nums, mid + 1, right);
                }
                Integer min = null;
                if (r1 != null && r2 != null) {
                    min = Math.min(r1, r2);
                }else if(r1 == null && r2 != null) {
                    min = r2;
                }else if(r1 != null && r2 == null) {
                    min = r1;
                }
                if (min == null)
                    min = nums[mid];
                else if (nums[mid] < min) {
                    min = nums[mid];
                }
                return min;
            }
        }
        return base;
    }

    public int findMin(int[] nums)
    {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[right] > nums[mid]) {
                right = mid;
            }else if(nums[right] == nums[mid]) {
                right--;
            }else { // 最右边的数字 < nums[mid]
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
