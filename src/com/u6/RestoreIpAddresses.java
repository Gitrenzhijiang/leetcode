package com.u6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIpAddresses {
    
    
    public static void main(String[] args) {
        // 1-255 都有可能
        String ipAddress = "010010";
        List<String> res = new RestoreIpAddresses().restoreIpAddresses(ipAddress);
        for (String str : res) {
            System.out.println(str);
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        // not a true ipAddress
        if (s.length() > 12) {
            return res;
        }
        restoreIpAddresses(s, new LinkedList<>(), 0, 4, res);
        return res;
    }
    public void restoreIpAddresses(String s, LinkedList<String> sb, int startIndex, int count, List<String> res) {
        if (count == 0 && startIndex == s.length()) {
            StringBuilder buff = new StringBuilder();
            for (String str : sb) {
                buff.append(str);
            }
            res.add(buff.toString());
            return;
        }
        for (int i = 1;i < 4 && (startIndex + i) <= s.length();i++) {
            int t = Integer.parseInt(s.substring(startIndex, startIndex + i));
            if (t <= 255 && ((i == 1 && t == 0) || (t > 0 && s.charAt(startIndex) != '0')) ) {
                String temp = String.valueOf(t);
                if (count > 1) {
                    temp += ".";
                }
                sb.addLast(temp);
                restoreIpAddresses(s, sb, startIndex + i, count - 1, res);
                sb.removeLast();
            }
        }
    }
    // we use dp to solve this problem
    // 
}
