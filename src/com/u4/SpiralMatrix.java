package com.u4;

import java.util.ArrayList;
import java.util.List;

/**
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {
				{7},	
				{9},
				{6}
		};
		List<Integer> res = new SpiralMatrix().spiralOrder(matrix);
		for(int tmp:res) {
			System.out.print(tmp+" ");
		}
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if(matrix.length<=0 || matrix[0].length<=0) {
			return res;
		}
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        
        int cen = Math.min(m, n);
        cen = cen % 2 == 0?cen/2 : cen/2+1;
        for(int i = 0;i < cen;i++){
            for(int j = 0;j < n;j++){
                res.add(matrix[i][i+j]);
            }
            for(int k = i+1;k < i+m-1;k++){
                res.add(matrix[k][i+n-1]);
            }
            if(m>1){
               for(int l = i+n-1;l>=i;l--){
                    res.add(matrix[i+m-1][l]);
                } 
            }
            if(n>1)
            for(int o = i+m-2;o > i;o--){
                res.add(matrix[o][i]);
            }
            m=m-2;
            n=n-2;
        }
        return res;
    }
}
