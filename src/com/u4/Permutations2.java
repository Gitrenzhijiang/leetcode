package com.u4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
s *
 */
public class Permutations2 {

	public static void main(String[] args) {
		int nums[] = {1, 1, 2};
		List<List<Integer>> res = new Permutations2().permuteUnique(nums);
		
		System.out.println(res.size());
		for(List<Integer> its:res) {
			for(Integer integer:its) {
				System.out.print(integer+"\t");
			}
			System.out.println();
		}
		
		Set<List<Integer>> set = new HashSet<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(3);list1.add(2);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);list2.add(3);
		
		
		set.add(list2);
		set.add(list1);
		
		System.out.println("haha"+set.size());
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		permuteUnique0(nums, res, new ArrayList<>(), 0);
		return res;
    }
	
	private void permuteUnique0(int[] nums, List<List<Integer>> res, List<Integer> list, int count) {
		if(count == nums.length) {//把结果加入到res中
			List<Integer> countRes = new ArrayList<>();
			for(Integer integer: list) {
				countRes.add(nums[integer]);
			}
			
			res.add(countRes);
			return;
		}
		List<Integer> temp = new ArrayList<>();
		for(int i = 0;i < nums.length;i++) {
			if( (list.isEmpty() || !list.contains(i))&&(temp.isEmpty()||!temp.contains(nums[i])) ) {
				temp.add(nums[i]);
				list.add(i);
				permuteUnique0(nums, res, list, count+1);
				list.remove(new Integer(i));
			}
		}
	}
	
}
