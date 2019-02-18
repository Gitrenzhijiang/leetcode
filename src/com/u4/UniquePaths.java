package com.u4;

public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		int m = 3;
		int n = 2;
		System.out.println(up.uniquePaths(m, n));
	}
    public int uniquePaths(int m, int n) {
    	/*int[][]dp = new int[n][m];
        for(int i = 0;i < n;i++) {
        	for(int j = 0;j < m;j++) {
        		if(i == 0 || j == 0) {
        			dp[i][j] = 1;
        		}else {
        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
        		}
        	}
        }
        return dp[n-1][m-1];*/
    	int num = m+n-2;
        int small = m>n?n-1:m-1;
        
        double fm = 1, fz = 1;
        for(int i = 1;i <= small;i++){
            fm *= i;
            fz *= num-i+1;
        }
        return (int)(fz/fm);
    }
   
}
