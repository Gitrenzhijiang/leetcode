package com.u11;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums = { 0, 0};
        System.out.println(ln.largestNumber(nums));
        System.out.println(ln.compare(12, 121));
    }
    public String largestNumber(int[] nums) {
        quickSort(nums);
        StringBuilder sb = new StringBuilder();
        boolean firstInput = false;
        for (int i = nums.length-1;i >= 0;i--) {
            if (firstInput == false && nums[i] != 0) {
                firstInput = true;
                sb.append(nums[i]);
            }
            else if (firstInput == false && i == 0) {
                sb.append(nums[i]);
            }else if (firstInput == true){
                sb.append(nums[i]);
            }
        }
        return sb.toString();
    }
    private void quickSort(int[] nums) {
        quickSort0(nums, 0, nums.length-1);
    }
    private void quickSort0(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        
     // [left+1, lt] < e    [gt, right] > e
        int lt = left;
        int gt = right + 1;
        int i = left + 1, e = nums[left];
        for (;i < gt;) {
            int t = compare(nums[i], e);
            if (t < 0) {
                swap(nums, ++lt, i++);
            }else if (t > 0) {
                swap(nums, --gt, i);
            }else {
                i++;
            }
        }
        if (lt > left) {
            swap(nums, lt, left); // [left,lt)<e [lt,gt)=e [gt...)>e
        }
        quickSort0(nums, left, lt-1);
        quickSort0(nums, gt, right);
    }
    private void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
    /**
     * @param a
     * @param b
     * @return
     */
    private int compare(int a, int b) {
        Deque<Integer> stack_a = new ArrayDeque<>();
        Deque<Integer> stack_b = new ArrayDeque<>();
        fact(a, stack_a);
        fact(b, stack_b);
        
        return compare0(stack_a, stack_b);
        
    }
    private int compare0(Deque<Integer> a, Deque<Integer> b) {
        Deque<Integer> copy = null;
        Deque<Integer> min, max;
        boolean t = false;
        if (a.size() > b.size()) {
            min = b;
            max = a;
            copy = new ArrayDeque<>(b);
            t = true;
        }else {
            max = b;
            min = a;
            copy = new ArrayDeque<>(a);
        }
        Integer res = null;
        // 34 9
        while (!min.isEmpty()) {
            Integer r_a = min.pop();
            Integer r_b = max.pop();
            if (r_a != r_b) {
                res = r_a - r_b;
                break;
            }
        }
        if (res == null && !max.isEmpty())
            res = compare0(copy, max);
        //判别符号
        if (res != null) {
            if (t == true) {
                return -res;
            }else {
                return res;
            }
        }
        return 0;
        
    }
    
    private void fact(int num, Deque<Integer> stack) {
        if (num >= 0 && num <= 9) {
            stack.push(num);
            return;
        }
        while (num != 0) {
            stack.push(num % 10);
            num /= 10;
        }
    }
}
