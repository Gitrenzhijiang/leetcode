package com.u6;
/*
 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {

    public static void main(String[] args) {
        String source = "afewefjewoiuroeiwjofi";
        String target = "oeurjofiiwfewawoiefje";
        System.out.println(new ScrambleString().scramble(source, target));
        System.out.println("=====");
        System.out.println(new ScrambleString().scramble_dp(source, target));
        System.out.println("++++++");
        System.out.println(new ScrambleString().scramble_dg(source, target));
    }
    //递归解决, 遍历source所有切割交换情况
    public boolean scramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        // target 分成两份[0, i) [i, ...)
        for (int i = 1;i < s2.length();i++) {
            String s11 = s2.substring(0, i);
            String s12 = s2.substring(i);
            String s21 = s1.substring(0, i);
            String s22 = s1.substring(i);
            if (scramble(s11, s21) && scramble(s12, s22))
                return true;
            s21 = s1.substring(s1.length()-i);
            s22 = s1.substring(0, s1.length()-i);
            if (scramble(s11, s21) && scramble(s12, s22))
                return true;
        }
        return false;
    }
    // dp[i][j][n] 
    // s1从i开始, s2从j开始, 长度为n 是否scrambleString
    public boolean scramble_dp(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        boolean res[][][] = new boolean[s1.length()][s2.length()][s1.length()+1];
        for (int i = 0;i < s1.length();i++) {
            for (int j = 0;j < s2.length();j++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        // s1  2 3 4 5
        for (int len = 2;len <= s1.length();len++) {
            for (int i = 0;i < s1.length() - len + 1;i++) {
                for (int j = 0;j < s2.length() - len + 1;j++) {
                    // [i k) [k,...
                    for (int k = 1;k < len;k++) {
                        res[i][j][len] = ((res[i][j][k] && res[i+k][j+k][len-k]) 
                                || (res[i][j+len-k][k] && res[i+k][j][len-k]));
                        if (res[i][j][len] == true)
                            break;
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }
    // 带备忘录 自顶向下方式
    public boolean scramble_dg(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        Boolean res[][][] = new Boolean[s1.length()][s2.length()][s1.length()+1];
        for (int i = 0;i < s1.length();i++) {
            for (int j = 0;j < s2.length();j++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        // 递归推导公式    res[i][j][len] = ((res[i][j][k] && res[i+k][j+k][len-k]) 
         // || (res[i][j+len-k][k] && res[i+k][j][len-k]));
        return scramble_dg0(0, 0, s1.length(), res);
    }
    private boolean scramble_dg0(int i, int j, int len, Boolean[][][]res) {
        if (res[i][j][len] != null)
            return res[i][j][len];
        boolean tag = false;
        for (int k = 1;k < len;k++) {
            tag = (scramble_dg0(i, j, k, res) && scramble_dg0(i+k, j+k, len-k, res))
                    || (scramble_dg0(i, j+len-k, k, res) && scramble_dg0(i+k, j, len-k, res));
            if (tag == true)
                break;
        }
        return tag;
    }
    
}
