package com.u5;

public class SearchinRotatedSortedArray2 {

	public static void main(String[] args) {
		int nums[] = {3, 5, 1};
		for(int i = 0;i < nums.length;i++) {
			if(nums[i] == 2)
				System.out.println("222222");
		}
		System.out.println(new SearchinRotatedSortedArray2().search0(nums, 1));
	}
	public boolean search0(int[]nums, int target) {
		int n = nums.length;
		if(n == 0)
			return false;
		int left = 0, right = n - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target)return true;
			else if(nums[mid] < nums[right]) {
				if(nums[mid] < target && nums[right] >= target) left = mid + 1;
				else right = mid - 1;
			}else if(nums[mid] > nums[right]) {
				if(nums[left] <= target && nums[mid] > target) right = mid - 1;
				else left = mid + 1;
			}else
				--right;
			
		}
		return false;
	}
}
