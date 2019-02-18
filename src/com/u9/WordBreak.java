package com.u9;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        WordBreak wb = new WordBreak();
        String testStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println(wb.wordBreak(testStr, wordDict));
        System.out.println(wb.wordBreak2(testStr, wordDict));
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        Boolean [] buff = new Boolean[s.length()];
        // 以i结尾的,0开始, 是否可以
        buff[0] = wordDict.contains(s.substring(0, 1))?true:false;
        for (int i = 1;i < s.length();i++) { 
            if (wordDict.contains(s.substring(0, i+1))) {
                buff[i] = true;
            }else {
                int j = 0;
                for (;j < i;j++) {
                    if (buff[j] && wordDict.contains(s.substring(j+1, i+1))) {
                        buff[i] = true;
                        break;
                    }
                }
                if (j == i) {
                    buff[i] = false;
                }
            }
        }
        return buff[s.length()-1];
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] buff = new Boolean[s.length()+1];
        return word0(s, wordDict, 0, buff);
    }
    private boolean word0(String s, List<String> wordDict, int start, Boolean[] buff) {
        if (buff[start] != null) {
            return buff[start];
        }
        if ("".equals(s.substring(start))) {
            return true;
        }
        for (int i = start;i < s.length();i++) {
            String sub = s.substring(start, i+1);
            if (wordDict.contains(sub)) {
                boolean t = word0(s, wordDict, i+1, buff);
                if (t == true) {
                    buff[start] = true;
                    return true;
                }
            }
        }
        buff[start] = false;
        return false;
    }
    

}
