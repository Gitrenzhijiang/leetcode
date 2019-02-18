package com.u5;
/*
 Given a sorted array nums, 
 remove the duplicates in-place such 
 that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array, 
you must do this by modifying the input array in-place with O(1) 
extra memory.
 */
public class RemoveDuplicate {

	public static void main(String[] args) {
		int [] nums = {1, 1, 2, 2, 2, 3, 3, 3};
		System.out.println(new RemoveDuplicate().removeDuplicates(nums));
		for(int i = 0;i < nums.length;i++) {
			System.out.print(nums[i] + " ");
		}
	}
	public int removeDuplicates(int[] nums) {
		int pre = 0, last = 0, count = 1;
		boolean iftz = false;
		for(pre = 1;pre < nums.length;) {
			if(nums[pre] == nums[last]) {
				count++;
			}else
				count = 1;
			if(count < 3 && pre - last > 1) {
				nums[++last] = nums[pre];
				
			}
			
			if(count > 2) {
				iftz = true;
				while(pre < nums.length) {
					if(nums[pre] != nums[last]) {
						break;
					}
					pre++;
				}
				if(pre == nums.length) {//´ý¶¨
					return last + 1;
				}
				count = 1;
				continue;
			}
			if(pre == nums.length)
				break;
			if(iftz == false){
				pre++;last++;
				
			}else{
				pre++;
			}
		}
		return last + 1;
	}
}
