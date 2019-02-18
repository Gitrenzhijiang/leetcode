package com.u6;
/**
 * 
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 * @author renzhijiang
 *
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] ms = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new MaximalRectangle().maximalRectangle(ms));
    }
    
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int ms[][] = new int[matrix.length][];
        for (int i = 0;i < ms.length;i++) {
            ms[i] = new int[matrix[i].length];
            for (int j = 0;j < ms[i].length;j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        ms[i][j] = 1;
                    }else {
                        ms[i][j] = ms[i-1][j] + 1;
                    }
                }
            }
            res = Math.max(res, largest(ms[i]));
        }
        return res;
    }
    // arr数组代表的最大面积
    private int largest(int[] arr) {
        int res = 0;
        for (int i = 0;i < arr.length;i++) {
            if (i + 1 < arr.length && arr[i + 1] > arr[i]) {
                continue;
            }
            // 找到局部峰值
            int min = arr[i];
            for (int j = i;j >= 0;j--) {
                min = Math.min(min, arr[j]);
                res = Math.max(res, min * (i - j + 1));
            }
        }
        return res;
    }
    
}
