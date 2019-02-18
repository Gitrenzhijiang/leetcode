package com.u6;
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class NumDecodings {

    public static void main(String[] args) {
        NumDecodings nd = new NumDecodings();
        String str = "1168963884134125126536966946586868418993819971673459188478711546479621135253876271366851168524933185";
        System.out.println(nd.numDecodings(str));
        System.out.println(nd.numDecodings2(str));
    }
    public int numDecodings(String s) {
        if (Integer.parseInt(s.substring(0, 1)) == 0)
            return 0;
        count = 0;
        numdecodings0(s);
        return count;
    }
    private int count = 0;
    private void numdecodings0(String s){
        if (s.length() <= 0) {
            count++;
            return;
        }
        if (s.length() >= 2) {
            int con2 = Integer.parseInt(s.substring(0, 2));
            if (con2 <= 26 && con2 >= 1 && (s.length() == 2 || (Integer.parseInt(s.substring(2, 3)) != 0))) {
                numdecodings0(s.substring(2));
            }
            if (con2 % 10 == 0) {
                return;
            }
        }
        if (s.length() >= 1){
            if (Integer.parseInt(s.substring(0, 1)) == 0) {
                return;
            }
            numdecodings0(s.substring(1));
        }
    }
    /////////dp///////////
    public int numDecodings2(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int [] dp = new int[s.length()];
        dp[0] = 1;
        if (s.length() > 1) {
            int t = Integer.parseInt(s.substring(0, 2));
            if (t <= 26 && t >= 1) {
                if (t % 10 == 0)
                    dp[1] = 1;
                else
                    dp[1] = 2;
            }else if (s.charAt(1) == '0'){
                return 0;
            }else {
                dp[1] = 1;
            }
        }
        for (int i = 2;i < s.length();i++) {
            if (s.charAt(i) != '0') {
                // 本身不为 0 
                // 如果 a[i-1] == 0, 
                // a[i-1] != 0, 看能否
                if (s.charAt(i - 1) == '0') {
                    dp[i] = dp[i - 1];
                }else {
                    int temp = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (temp >= 1 && temp <= 26) {
                        dp[i] = dp[i - 2] + dp[i - 1];
                    }else {
                        dp[i] = dp[i - 1];
                    }
                }
            }else {// a[i] = 0 情况下
                int temp = Integer.parseInt(s.substring(i - 1, i + 1));
                if (temp <= 26 && temp >= 1) {
                    dp[i] = dp[i - 2];
                }else {
                    return 0;
                }
            }
        }
        return dp[s.length()-1];
    }
    
}
