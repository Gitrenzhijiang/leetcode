package com.u7;

public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "abcdeadjoif";
        String s2 = "oiueoruiqop";
        String s3 = "abcoiuedeoruadjoiiqopf";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3, 0, 0, 0));
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }
    public boolean isInterleave(String s1, String s2, String s3, int s1_index, int s2_index, int s3_index) {
        if (s3_index == s3.length() && s1_index == s1.length() && s2_index == s2.length()) {
            return true;
        }
        if (s3_index == s3.length()) {
            return false;
        }
        char c3 = s3.charAt(s3_index);
        Character c1 = null;
        if (s1_index < s1.length()) {
            c1 = s1.charAt(s1_index);
        }
        Character c2 = null;
        if (s2_index < s2.length()) {
            c2 = s2.charAt(s2_index);
        }
        if (c1 == null && c2 == null) {
            return false;
        }else if(c1 == null && c2 != null) {
            if (c2 != c3)
                return false;
            return isInterleave(s1, s2, s3, s1_index, s2_index + 1, s3_index + 1);
        }else if(c1 != null && c2 == null) {
            if (c1 != c3)
                return false;
            return isInterleave(s1, s2, s3, s1_index + 1, s2_index, s3_index + 1);
        }
        if (c1 == c2 && c1 == c3) {
            // 两种情况
            boolean t1 = isInterleave(s1, s2, s3, s1_index + 1, s2_index, s3_index + 1);
            if (t1 != true) {
                return isInterleave(s1, s2, s3, s1_index, s2_index + 1, s3_index + 1);
            }else {
                return true;
            }
        }else if (c1 == c3 && c2 != c3) {
            return isInterleave(s1, s2, s3, s1_index + 1, s2_index, s3_index + 1);
        }else if (c2 == c3 && c1 != c3) {
            return isInterleave(s1, s2, s3, s1_index, s2_index + 1, s3_index + 1);
        }
        return false;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }
        // dp[i][j] 表示0-i   0-j    0-i+j+1 是否isInterleave
        // dp[i][j] = dp[i-1][j] && 
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1;i <= s1.length();i++) { // 
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1;i <= s2.length();i++) {
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for (int i = 1;i <= s1.length();i++) {
            for (int j = 1;j <= s2.length();j++) {
                if (dp[i][j] == null) {
                    dp[i][j] = (dp[i-1][j] == true && s3.charAt(j+i-1) == s1.charAt(i-1))
                            || (dp[i][j-1] == true && s3.charAt(j+i-1) == s2.charAt(j-1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
