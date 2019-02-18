package com.u6;
/**
 * Given n non-negative integers representing the histogram's bar height where
 *  the width of each bar is 1, find the area of largest rectangle 
 *  in the histogram.
 *  
 *  bove is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *  The largest rectangle is shown in the shaded area, which has area = 10 unit.

 数组中的数值非负, 找出面积最大的矩形 

Example:

Input: [2,1,5,6,2,3]
Output: 10
 * @author renzhijiang
 *
 */
public class LargestRectangleinHistogram {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));
        System.out.println(largestRectangleArea_0(arr));
    }
    public static int largestRectangleArea(int[] heights) {
        // height[left, right]  min是其中最矮元素, res是当前最优结果
        int res = 0;
        for (int i = 0;i < heights.length;i++) {
            if (i+1 < heights.length && heights[i] <= heights[i+1]) {
                continue;
            }
            int min = heights[i];
            for (int j = i;j >= 0;j--) {
                min = Math.min(min, heights[j]);
                if (res < (i-j+1)*min) {
                    res = min*(i-j+1);
                }
            }
        }
        return res;
    }
    
    
    // 效率极低
    public static int largestRectangleArea_0(int[] heights) {
        int help[][] = new int[heights.length][heights.length];
        // help[i][j] 表示从 i->j 最小的数是
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < help.length;i++) {
            for (int j = i;j < help.length;j++) {
                if (i == j) {
                    help[i][j] = heights[i];
                }else if(heights[j] < help[i][j-1]) {
                    help[i][j] = heights[j];
                }else {
                    help[i][j] = help[i][j-1];
                }
                if (help[i][j]*(j-i+1) > max) {
                    max = help[i][j]*(j-i+1);
                }
            }
        }
        return max;
    }
    
}
