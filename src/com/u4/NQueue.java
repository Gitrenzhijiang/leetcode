package com.u4;

import java.util.ArrayList;
import java.util.List;

public class NQueue {

	public static void main(String[] args) {
		
	}
	
	public List<List<String>> solveNQueens(int n) {
        /*
                思路:1.逐行寻找皇后的位子
        2.探测法，递归
        3.递归到最后一行后，找到位子后，将当前的二位数组保存到list
        */
        String [][] dp = new String[n][n];
        //初始化
        for(int i = 0;i < n;i++){
            dp[i] = new String[n];
            for(int j = 0;j < n;j++){
                dp[i][j] = ".";
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        solveNQueens(dp, n, res, 0);
        return res;
    }
    
    private void solveNQueens(String[][] dp, int n, List<List<String>> res, int cur_row){
        if(cur_row == n){//结束 
            List<String> list = new ArrayList<String>();
            for(int i = 0;i < n;i++){
                String temp = "";
                for(int j = 0;j < n;j++){
                    temp += dp[i][j];
                }
                list.add(temp);
            }
            res.add(list);
        }
        for(int j = 0;j < n;j++){
            if(isok(dp, n, cur_row, j) == true){
                dp[cur_row][j] = "Q";
                solveNQueens(dp, n, res, cur_row+1);
                dp[cur_row][j] = ".";
            }
        }
    }
    //测试第i行,第j列是否可以放女王
    private boolean isok(String[][] dp,int n,int i, int j){
        for(int k = 0;k < n;k++){
            /*if(k != j && "Q".equals(dp[i][k])){
                return false;
            }*/
            if(k != i && "Q".equals(dp[k][j])){
                return false;
            }
        }
        //对角线
        int copy_i = i, copy_j = j;
        while(copy_i > 0 && copy_j > 0){
            copy_i--;
            copy_j--;
            if("Q".equals(dp[copy_i][copy_j])){
                return false;
            }
        }
        copy_i = i;
        copy_j = j;
        while(copy_i > 0 && copy_j < n-1){
            copy_i--;
            copy_j++;
            if("Q".equals(dp[copy_i][copy_j])){
                return false;
            }
        }
        return true;
    }

}
