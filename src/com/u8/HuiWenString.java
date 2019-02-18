package com.u8;

import java.util.ArrayList;
import java.util.List;

public class HuiWenString {

    public static void main(String[] args) {
        String str = "cbbbcc";
        List<List<String>> ret = new HuiWenString().partition(str);
        for (List<String> list:ret) {
            for (String t:list) {
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        p0(s, new ArrayList<>(), res);
        return res;
    }
    private List<List<String>> p0(String s, List<String> list, List<List<String>> res) {
        if ("".equals(s)) {
            res.add(new ArrayList<>(list));
            return res;
        }
        // s的 i-j 是回文的, ..
        for (int i = 1;i <= s.length();i++) {
            String subString = s.substring(0, i);
            if (isHuiwen(subString)){
                list.add(subString);
                p0(s.substring(i), list, res);
                list.remove(list.size()-1);
            }
        }
        
        return res;
    }
    private boolean isHuiwen(String s) {
        int i = 0, j = s.length()-1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
}
