package com.u5;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args) {
		int []nums = {1, 2, 3};
		List<List<Integer>> res = new Subsets().subsets(nums);
		for(List<Integer> list:res) {
			for(int temp:list) {
				System.out.print(temp+" ");
			}
			System.out.println();
		}
	}
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
        subsets0(0, nums, res);
        res.add(new ArrayList<>());
        return res;
    }
	private void subsets0(int cur, int[]nums, List<List<Integer>> part) {
		if(cur >= nums.length)
			return;
		List<List<Integer>> res = new ArrayList<>();
		for(List<Integer> list:part) {
			List<Integer> newAdd = new ArrayList<>(list);
			newAdd.add(nums[cur]);
			res.add(newAdd);
		}
		List<Integer> o = new ArrayList<>();
		o.add(nums[cur]);
		res.add(o);
		part.addAll(res);
		subsets0(cur+1, nums, part);
	}
}
