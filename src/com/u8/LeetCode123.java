package com.u8;

/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
*/
public class LeetCode123 {

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int res = new LeetCode123().maxProfit(prices);
        System.out.println(res+":" + new LeetCode123().maxProfit_2(prices));
    }
    /**
     * 思路:动态规划求解, local[i][j]是在到达第i天最多进行j次交易且在最后一天卖出的最大收益
     * global[i][j]为在到达第i天时最多可进行j次交易的最大利润,全局最优
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int local[][] = new int[prices.length][3];
        int global[][] = new int[prices.length][3];
        // local[0][x] = 0 , global[0][x] = 0
        for (int i = 1;i < prices.length;i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1;j <= 2;j++) {
                // local[i][j] = 如果用上了最后一天卖出,global[i-1][j-1]加的是j-1次的.
                //   如果没有,i-1--->i算一次.;;; 这样并不违反global的定义.
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(0, diff), local[i-1][j] + diff);
                global[i][j] = Math.max(local[i][j], global[i-1][j]);
            }
        }
        return global[prices.length-1][2];
    }
    public int maxProfit_2(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int[] local = new int[3];
        int[] global = new int[3];
        for (int i = 1;i < prices.length;i++) {
            for (int j = 2;j >=1 ;j--) {
                int diff = prices[i] - prices[i-1];
                local[j] = Math.max(global[j-1] + Math.max(0, diff), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }
    
}
