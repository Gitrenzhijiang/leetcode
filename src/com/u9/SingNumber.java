package com.u9;

public class SingNumber {

    public static void main(String[] args) {
        int nums[] = {1, 2, 99, 2, 1, 9};
        System.out.println(new SingNumber().singleNumber(nums));
    }
    
    public int singleNumber(int[] nums) {
        for (int i = 1;i < nums.length;i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }
}
