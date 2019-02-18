package com.u8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

public class WordLadder {

    public static void main(String[] args) {
//        String s = "hit";
//        String e = "cog";
//        List<String> wordList = new ArrayList<>();
//        wordList.add("hot");wordList.add("cog");
//        wordList.add("dot");wordList.add("dog");
//        wordList.add("log");wordList.add("lot");wordList.add("log");
        String s = "hot";
        String e = "dog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");wordList.add("dog");wordList.add("cog");
        wordList.add("pot");wordList.add("dot");
        
        
        System.out.println(new WordLadder().ladderLength(s, e, wordList));
        
    }
    // 0:不可达, 其他>0 :转换步骤数
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将wordList放入TreeSet中
        TreeSet<String> wordSet = new TreeSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> path = new HashMap<>();
        path.put(beginWord, 1);
        
        queue.add(beginWord);
        // 对于每一个
        while (!queue.isEmpty()) {
            String begin = queue.remove();
            for (int i = 0;i < begin.length();i++) {
                // 每一位都有a-z中变化
                char x = 'a';
                for (;x <= 'z';x++) {
                    if (begin.charAt(i) == x) {
                        continue;
                    }
                    char[] t = begin.toCharArray();
                    t[i] = x;
                    String newString = new String(t);
                    // 查看是否有
                    if (wordSet.contains(newString) && newString.equals(endWord)) {
                        return path.get(begin) + 1;
                    }else if(wordSet.contains(newString) && path.get(newString) == null) {
                        
                        queue.add(newString);
                        
                        path.put(newString, path.get(begin) + 1);
                    }
                    
                    
                }
            }
           
        }
        return 0;
        
    }
    
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int endWordIndex = -1;
        for (int i = 0;i < wordList.size();i++){
            if (wordList.get(i).equals(beginWord)){
                endWordIndex = i;
                break;
            }
        }
        int endWordIndex2 = -1;
        for (int i = 0;i < wordList.size();i++){
            if (wordList.get(i).equals(endWord)){
                endWordIndex2 = i;
                break;
            }
        }
        if (endWordIndex2 == -1) {
            return 0;
        }
        int res = 0;
        Integer[][] buff = new Integer[wordList.size()][wordList.size()];
        if (endWordIndex == -1){// di一个元素不在字典
            wordList.add(beginWord);
            res = ladder0(wordList.size()-1, endWordIndex2, wordList, buff, new ArrayList<Integer>());
        }else {
            res = ladder0(endWordIndex, endWordIndex2, wordList, buff, new ArrayList<Integer>());
        }
        return res;
    }
    // ladder0[i][j] 从第i个到第j个转换需要的最少步数 0表示不可达, 
    public int ladder0(int i, int j, List<String> wordList, Integer[][] buff, List<Integer> use){
        // arr[i][j] = min(arr[i][k]) + 1;/   就是j-->k
        // 找到从j->所能到的所有的k, k!=j
        
        int min = Integer.MAX_VALUE;
        for (int k = 0;k < wordList.size();k++){
            if (k != j && isC(wordList.get(k), wordList.get(j))){
                // 如果第k个元素是i
                int temp = 0;
                if (k == i){
                    min = 2;
                    break;
                }else if(use.contains(k)) {
                    continue;
                }else{
                    use.add(j);
                    temp = ladder0(i, k, wordList, buff, use);
                    use.remove(new Integer(j));
                    if (temp == 0) {
                        continue;
                    }else {
                        temp++;
                    }
                    
                }
                
                if (temp < min){
                    min = temp;
                }
            }
        }
        int ret = -1;
        if (min == Integer.MAX_VALUE) {
            ret = 0;
        }else {
            ret = min;
        }
        buff[i][j] = ret;
        return ret;
    }
    private static Map<String, String> map = new HashMap<>();
    private boolean isC(String s, String t) {
//        String value = map.get(s+"#"+t);
//        if (value != null){
//            return true;
//        }else if(s.length() != t.length()) {
//            return false;
//        }
        int tag = 0;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) != t.charAt(i)) {
                tag++;
                if (tag > 1) {
                    break;
                }
            }
        }
        if (tag == 1){
//            map.put(s+"#"+t, t);
            return true;
        }else{
            return false;
        }
    }
}
