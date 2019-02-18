package com.u4;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		int res[][] = null;
		res = new SpiralMatrix2().generateMatrix(5);
		for(int c = 0;c < res.length;c++) {
			for(int z = 0;z < res.length;z++) {
				System.out.print(res[c][z] + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] generateMatrix(int n) {
        if(n <= 0) {
        	return new int[][] {};
        }
        int numCen = n % 2 == 0?n/2:n/2+1;
        int res[][] = new int[n][n];
        int startValue = 1;
        for(int i = 0;i < numCen;i++) {
        	int cur_jcs = n - 2*i;
        	for(int j = 0;j < cur_jcs;j++) {
        		res[i][i+j] = startValue+j;
        	}
        	
        	for(int k = 0;k < cur_jcs-1;k++) {
        		res[i+k+1][i+cur_jcs-1] = res[i+k][i+cur_jcs-1] + 1;
        	}
        	
        	for(int l = cur_jcs - 2;l >= 0;l--) {
        		res[i+cur_jcs-1][i+l] = res[i+cur_jcs-1][i+l+1] + 1;
        	}
        	for(int m = cur_jcs - 2;m > 0;m--) {
        		res[i+m][i] = res[i+m+1][i] + 1;
        	}
        	startValue = startValue + 4 * cur_jcs - 4;
        }
        return res;
    }

}
