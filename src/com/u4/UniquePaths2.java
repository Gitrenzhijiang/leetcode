package com.u4;
/**
 * 
 * 
 * 
 */
public class UniquePaths2 {
	public static void main(String[] args) {
		int [][] obstacleGrid = {
				{0, 0, 0},
				{1, 1, 0},
				{0, 0, 0}
		};
		System.out.println(new UniquePaths2().uniquePathsWithObstacles(obstacleGrid));
	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length <= 0) {
			return 0;
		}
		int n = obstacleGrid.length;//行数
		int m = obstacleGrid[0].length;//列数
		int[][]dp = new int[n][m];
		if(obstacleGrid[0][0] == 1)//开始处有障碍物
			return 0;
		else
			dp[0][0] = 1;
        for(int i = 0;i < n;i++) {
        	for(int j = 0;j < m;j++) {
        		if(obstacleGrid[i][j] == 1) {
        			dp[i][j] = 0;
        		}else {
	        		if(i == 0 && j > 0) {
	        			dp[i][j] = dp[i][j-1];
	        		}else if(j == 0 && i > 0) {
	        			dp[i][j] = dp[i-1][j];
	        		}else if(i > 0 && j > 0){
	        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
	        		}
        		}
        	}
        }
        return dp[n-1][m-1];
	}
}
