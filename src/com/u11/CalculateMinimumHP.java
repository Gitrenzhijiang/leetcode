package com.u11;
/*
一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

为了尽快到达公主，骑士决定每次只向右或向下移动一步。

 

编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。

例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。

-2 (K)  -3  3
-5  -10 1
10  30  -5 (P)
 

说明:

骑士的健康点数没有上限。

任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class CalculateMinimumHP {

    public static void main(String[] args) {
        
    }
    /**
     * 还可以对存储空间进行优化， 但是降低了可阅读性。
     * 本题目的状态转移方程无法确定，但是通过倒推可以确定从后往前的状态转移方程.
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        for (int i = row - 1;i >= 0;i--) {
            for (int j = col - 1;j >= 0;j--) {
                int min = Integer.MAX_VALUE;
                if (i == row - 1 && j == col - 1) {
                    min = 1;
                }else if (i == row - 1){
                    min = dp[i][j+1];
                }else if (j == col - 1){
                    min = dp[i+1][j];
                }else {
                    min = Math.min(dp[i+1][j], dp[i][j+1]);
                }
                dp[i][j] = Math.max(1, min-dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}