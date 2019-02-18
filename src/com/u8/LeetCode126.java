package com.u8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

/*
给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
 */
public class LeetCode126 {

    public static void main(String[] args) {
        /*
         "hit"
         "cog"
         ["hot","cog","dot","dog","hit","lot","log"]
         */
        String s = "hit";
        String e = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");wordList.add("cog");
        wordList.add("dot");wordList.add("dog");
        wordList.add("hit");wordList.add("lot");wordList.add("log");
        LeetCode126 lc = new LeetCode126();
        List<List<String>> res = lc.findLadders(s, e, wordList);
        System.out.println("大小:" + res.size());
        for (List<String> list : res) {
            for (String str:list) {
                System.out.print(str + "  ");
            }
            System.out.println();
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // 路径集
        Queue<List<String>> queue = new LinkedList<>();
        List<String> q = new ArrayList<>();
        q.add(beginWord);
        queue.add(q);
        int level = 1, minLevel = Integer.MAX_VALUE;
        
        List<String> newWord = new ArrayList<>(0);
        while (!queue.isEmpty()) {
            List<String> path = queue.remove();
            if (path.size() > level) {
                level = path.size();
                for (String str:newWord) {
                    if (wordList.contains(str)) {
                        wordList.remove(str);
                    }
                }
                newWord.clear();
                if (level > minLevel){
                    break;
                }
            }
            // 取出最后一个元素
            String last = path.get(path.size()-1);
            
            // 最后一个元素每一位都有'a'-'z'种变化
            
            for (int i = 0;i < last.length();i++) {
                char[] tlast = last.toCharArray();
                for (char x = 'a'; x <= 'z';x++) {
                    tlast[i] = x;
                    String newString = new String(tlast);
                    if (wordList.contains(newString)) {
                        // 包含最新的变换
                        newWord.add(newString);
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(newString);
                        if (!newString.equals(endWord)) {
                            queue.add(newPath);
                        }else {
                            // 最后一个
                            res.add(newPath);
                            minLevel = level;
                        }
                    }
                }
            }
        }
        return res;
    }
    
}
