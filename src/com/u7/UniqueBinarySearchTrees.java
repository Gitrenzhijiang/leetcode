package com.u7;

public class UniqueBinarySearchTrees {
    
    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(12));
        System.out.println(new UniqueBinarySearchTrees().numTrees_fdg(12));
    }
    
    public int numTrees(int n) {
        return numTrees0(1, n);
    }
    
    public int numTrees0(int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 1;
        }
        int count = 0;
        for (int i = left;i <= right;i++) {
            int lefts = numTrees0(left, i - 1);
            int rights = numTrees0(i + 1, right);
            if (lefts == 0) {
                count += rights;
            }else if (rights == 0) {
                count += lefts;
            }else {
                count += (lefts * rights);
            }
            
        }
        return count;
    }
    
    public int numTrees_fdg(int n) {
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 1;len <= n;len++) {
            for (int i = 1;i <= n - len + 1;i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                int count = 0;
                for (int k = i;k <= j;k++) {
                    if (k == i) {
                        count += dp[k + 1][j];
                    }else if (k == j) {
                        count += dp[i][k - 1];
                    }else {
                        count += (dp[i][k-1] * dp[k+1][j]);
                    }
                }
                dp[i][j] = count;
            }
        }
        return dp[1][n];
    }
    
}
