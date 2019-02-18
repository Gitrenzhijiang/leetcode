package com.u7;
/*
给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。

一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

示例 1:

输入: S = "rabbbit", T = "rabbit"
输出: 3
解释:

如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。
(上箭头符号 ^ 表示选取的字母)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
示例 2:

输入: S = "babgbag", T = "bag"
输出: 5
解释:

如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 
(上箭头符号 ^ 表示选取的字母)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
 */
public class DistinctSubString {

    public static void main(String[] args) {
        DistinctSubString dss = new DistinctSubString();
        
        
        String s = "abababababadsd";
        String t = "ab";
        //System.out.println(dss.numDistinct(s, t));
        
        System.out.println(dss.numDistinct1(s, t));
    }
    public int numDistinct(String s, String t) {
        return numDistinct0(s, t, 0, 0, new Integer[s.length()][t.length()]);
    }
    // 非递归写法
    private int numDistinct1(String s, String t) {
        if (s.length() == 0)
            return 0;
        Integer[][] dp = new Integer[t.length()][s.length()];
        // 首先初始化t.length()-1
        for (int i = s.length()-1;i >= 0;i--) {
            int temp = s.charAt(i) == t.charAt(t.length()-1)? 1:0;
            if (i == s.length()-1) {
                dp[t.length()-1][i] = temp;
            }else {
                dp[t.length()-1][i] = temp + dp[t.length()-1][i+1];
            }
        }
        for (int i = t.length()-2;i >= 0;i--) {
            for (int j = s.length()-1;j >= 0;j--) {
                if (j == s.length()-1) {
                    // t 包含的元素至少2个, 而s只包含一个
                    dp[i][j] = 0;
                }else if (t.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + dp[i][j+1];
                }else {
                    dp[i][j] = dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
    // 递归写法
     private int numDistinct0(String s, String t, int i, int j, Integer[][] buff) {
        if (t.length() == j) {
            return 0;
        }
        if (s.length()-i < t.length()-j) {
            return 0;
        }
        if (buff[i][j] != null) {
            return buff[i][j];
        }
        // j = t.length()-1 对于非递归写法, 优势在于这里的计算将会消除
        if (t.length() - 1 == j) {
            int res = 0;
            for (int k = i;k < s.length();k++) {
                if (s.charAt(k) == t.charAt(j)) {
                    res++;
                }
            }
            return res;
        }
        if (s.charAt(i) == t.charAt(j)) {
            return numDistinct0(s, t, i+1, j+1, buff)
                    + numDistinct0(s, t, i+1, j, buff);
        }else {
            // s[i] != s[j], 
            return numDistinct0(s, t, i+1, j, buff);
        }
    }
}
