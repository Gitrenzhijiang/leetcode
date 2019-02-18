package com.u9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak2 {
    
    public static void main(String[] args) {
        
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        WordBreak2 wb = new WordBreak2();
        String testStr = "catsanddog";
        for (String str : wb.wordBreak2(testStr, wordDict)) {
            System.out.println(str);
        }
    }
    // 尝试自上而下递归
    public List<String> wordBreak2(String s, List<String> wordDict) {
        return word0(new ArrayList[1+s.length()], s, wordDict, 0);
    }
    private List<String> word0(List[]dp, String s, List<String>wordDict, int start){
        if (dp[start] != null) {
            return dp[start];
        }
        List<String> ret = new ArrayList<>();
        for (int i = start;i < s.length();i++) {
            String sub = s.substring(start, i+1);
            if (wordDict.contains(sub)) {
                
                if (i + 1 >= s.length()) {
                    ret.add(sub);
                }else {
                    List<String> tempList = word0(dp, s, wordDict, i+1);
                    if (!tempList.isEmpty()) {
                        for (String str : tempList) {
                            ret.add(sub + " " + str);
                        }
                    }
                }
                
            }
        }
        dp[start] = ret;
        return ret;
    }
    
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        // s中以i结尾的字符串, 在当前字典下的分隔组合
        @SuppressWarnings("unchecked")
        List<String> dp[] = new ArrayList[s.length()];
        // 对dp[1-n)进行计算, 
        for (int i = 0;i < s.length();i++) {
            List<String> tList = new ArrayList<>(0);
            for (int j = -1;j < i;j++) {
                // 0, j   j+1, i
                String t_str = s.substring(j+1, i+1);
                if ((j == -1 && wordDict.contains(t_str)) ||
                        j>=0 && !dp[j].isEmpty() && wordDict.contains(t_str)) {
                    if (j >= 0) {
                        // 取出第j次的所有string, 加上" curString"
                        for (String jstr : dp[j]) {
                            tList.add(jstr + " " + t_str);
                        }
                    } else {
                        tList.add(t_str);
                    }
                }
            }
            dp[i] = tList;
        }
        return dp[s.length()-1];
    }

}
