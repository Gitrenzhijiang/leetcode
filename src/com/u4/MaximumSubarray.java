package com.u4;

import java.util.Date;
import java.util.Random;

/**
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, 
try coding another solution using the divide and 
conquer approach, which is more subtle.
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		//int length = 5000000; //5����
		//int[]nums = new int[length];
		//System.out.println(ms.maxSubArray(nums));
		/*Random r = new Random();
		for(int i = 0;i < length;i++) {
			nums[i] = r.nextInt(500000)-250000;
		}*/
		/*Date d1 = new Date();
		System.out.println(ms.maxSubArray(nums));
		//System.out.println(ms.maxSubArray2(nums)); �Ѿ�stackoverflowError
		Date d2 = new Date();
		System.out.println(d2.getTime()-d1.getTime());
		*/
		int[]nums = {-2, 1, -3, 4, 2};
		int n = 5;
		System.out.println(ms.maxSubArray(nums));
		System.out.println(ms.maxSubArray2(nums));
		System.out.println(ms.maxSubArray3(nums));
	}
	//ʹ������� o(n)�������
	public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];//���
        int []buff = new int[n];//���ñ������
        buff[0] = nums[0];
        
        for(int i = 1;i < n;i++){
            buff[i] = buff[i - 1] > 0?buff[i-1] + nums[i]:nums[i];
            if(buff[i] > res){
                res = buff[i];
            }
        }
        return res;
    }
	//�ݹ��㷨������˼��
	//ʱ�临�Ӷȵͣ��������n̫��,stackOverflowError
	private int max = 0;
	public int maxSubArray2(int[] nums) {
        int n = nums.length;
        maxsubarr_dg(nums, n-1);
        return this.max;
    }
	//0-n ������
	private int maxsubarr_dg(int[]nums, int n) {
		if(n == 0)
			return nums[0];
		int pre = maxsubarr_dg(nums, n-1);
		int res = 0;
		if(pre > 0) {
			res = pre + nums[n];
		}else {
			res = nums[n];
		}
		if(res > max)
			max = res;
		return res;
	}
	//ȡ��һ���� / ֱ����һ������ʼ
	public int maxSubArray3(int[] nums) {
       int res = nums[0];
       int max = nums[0];
       for(int i = 1;i < nums.length;i++) {
    	   res = Math.max(res+nums[i], nums[i]);
    	   max = Math.max(max, res);
       }
       return max;
    }
	
	//����˼�룺�����ڶ��ֲ��ҷ����ҵ����ߵ�����
}
