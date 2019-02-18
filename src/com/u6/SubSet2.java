package com.u6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class SubSet2 {

    public static void main(String[] args) {
        int[]nums = {1, 1, 2, 2};
        
        List<List<Integer>> res = new SubSet2().subsetsWithDup(nums);
        for (int i = 0;i < res.size();i++) {
            List<Integer> tempList = res.get(i);
            for (Integer ele:tempList) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i <= nums.length;i++)
            subset0(nums, -1, i, new ArrayList<>(), res);
        return res;
    }
    
    private void subset0(int[] nums, int lastIndex, int count, List<Integer> curSet, List<List<Integer>> res){
        if (count == 0){
            res.add(new ArrayList<Integer>(curSet));
        }else{
            List<Integer> cuv = new ArrayList<>();
            for (int i = lastIndex != -1?lastIndex+1:0; i < nums.length;i++){
                if (cuv.contains(nums[i]))
                    continue;
                curSet.add(nums[i]);
                // 保存已经遍历了这个
                cuv.add(nums[i]);
                subset0(nums, i, count-1, curSet, res);
                curSet.remove(new Integer(nums[i]));
            }
        }
    }
}
