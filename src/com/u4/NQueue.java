package com.u4;

import java.util.ArrayList;
import java.util.List;

public class NQueue {

	public static void main(String[] args) {
		
	}
	
	public List<List<String>> solveNQueens(int n) {
        /*
                ˼·:1.����Ѱ�һʺ��λ��
        2.̽�ⷨ���ݹ�
        3.�ݹ鵽���һ�к��ҵ�λ�Ӻ󣬽���ǰ�Ķ�λ���鱣�浽list
        */
        String [][] dp = new String[n][n];
        //��ʼ��
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
        if(cur_row == n){//���� 
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
    //���Ե�i��,��j���Ƿ���Է�Ů��
    private boolean isok(String[][] dp,int n,int i, int j){
        for(int k = 0;k < n;k++){
            /*if(k != j && "Q".equals(dp[i][k])){
                return false;
            }*/
            if(k != i && "Q".equals(dp[k][j])){
                return false;
            }
        }
        //�Խ���
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
