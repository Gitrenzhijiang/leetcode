package com.u5;

public class SortColors {

	public static void main(String[] args) {
		int [] arr = {2, 0, 2, 1, 1, 0};
		new SortColors().sortColors(arr);
		for(int i = 0;i < arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	public void sortColors(int[] nums) {
		int button = nums.length-1;
        int head = 0;
        for(int i = 0;i <= button;i++){
            if(nums[i] == 2){
                swap(nums, i--, button--);
            }else if(nums[i] == 0){
                swap(nums, i, head++);
            }
        }
    }
    private void swap(int []nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}