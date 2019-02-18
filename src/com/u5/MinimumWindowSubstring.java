package com.u5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String res = new MinimumWindowSubstring().minWindow2(s, t);
		System.out.println(res);
	}
	/**
	 * 思路：首先为每一个A 或 B 或C 建立一个List,存放
	 *  { 
	 *  	int index
	 *  }
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
        int t_n = t.length();
        List<Character> set = new ArrayList<>();//存放了A,B,C
        for(int i = 0;i < t_n;i++) {
        	set.add(t.charAt(i));
        }
        //多个桶
        List<Integer> [] lists = new List[set.size()];
        for(int i = 0;i < lists.length;i++) {
        	lists[i] = new ArrayList<>();//i == 0 lists[0] 存放A
        }
        //遍历所有的s
        for(int j = 0;j < s.length();j++) {
    		char c = s.charAt(j);
    		if(!set.contains(c))//如果c不属于set中的任何一个
    			continue;
    		for(int k = 0;k < set.size();k++) {
    			if(set.get(k).equals(c)) {
    				lists[k].add(j);
    			}
    		}
    	}
       //开始计算
        int[]res = new int[2];res[0] = 0;res[1] = s.length();
        fun0(lists, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, res, new ArrayList<>());
        if(res[0] == 0 && res[1] == s.length())
        	return "";
        return s.substring(res[0], res[1]+1);
    }
	private void fun0(List<Integer>[] lists, int curIndex, int minIndex, int maxIndex, int[]res, List<Integer> midRes) {
		int min = minIndex, max = maxIndex;
		boolean tag = false;
		if(curIndex == lists.length-1)
			tag = true;
		for(int i = 0;i < lists[curIndex].size();i++) {
			int temp = lists[curIndex].get(i);
			if(midRes.contains(temp)) {
				continue;
			}
			if(temp > maxIndex)
				maxIndex = temp;
			if(temp < minIndex)
				minIndex = temp;
			midRes.add(temp);
			if(!tag) {
				fun0(lists, curIndex+1, minIndex, maxIndex, res, midRes);
			}else {
				if((res[1] - res[0]) > (maxIndex - minIndex)) {
					res[0] = minIndex;
					res[1] = maxIndex;
				}
			}
			midRes.remove(new Integer(temp));
			minIndex = min;
			maxIndex = max;
		}
	}

	
	public String minWindow2(String s, String t) {
		if(s.length() < t.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0;i < t.length();i++) {
			char c = t.charAt(i);
			if(map.containsKey(c)) {
				map.replace(c, map.get(c)+1);
			}else
				map.put(c, 1);
		}
		int left = 0, right = 0, minValue = Integer.MAX_VALUE;
		int count = 0;
		String res = "";
		//遍历s
		for(right = 0;right < s.length();right++) {
			char c = s.charAt(right);
			if(map.containsKey(c)) {
				map.replace(c, map.get(c)-1);
				if(map.get(c) >= 0)
					count++;
				while(count == t.length()) {
					//更新minString
					if(right - left + 1 < minValue) {
						minValue = right - left + 1;
						res = s.substring(left, right+1);
					}
					char lte = s.charAt(left);
					if(map.containsKey(lte)) {
						map.replace(lte, map.get(lte)+1);
						if(map.get(lte) > 0)//注意这里是>
							count--;
					}
					left++;
				}
			}
		}
		return res;
	}
}
