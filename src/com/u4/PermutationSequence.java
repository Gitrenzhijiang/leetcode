package com.u4;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		int n = 4;
		int k = 9;
		System.out.println(new PermutationSequence().getPermutation(n, k));
	}
	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<>();
		//≥ı ºªØlist
		for(int i = 1;i <= n;i++)
			list.add(i);
		String res = "";
		
		int start = 1;
		int end = 0;
        for(int i = 0;i < n-1;i++) {
        	int num_qk = getN_jc(n-i-1);
        	int index = k % num_qk == 0? k/num_qk:k/num_qk+1;
        	
        	res+=list.remove(index-1);
        	start = index-1==0?start:start+(index-1)*num_qk;
        	end = start+num_qk-1;
            k -= ((index-1)*num_qk);
            if(start==end) {
            	break;
            }
        }
        res+=list.remove(0);
        return res;
    }
	private int getN_jc(int n) {
		if(n == 0)return 0;
		int res = 1;
		for(int i = n;i > 1;i--) {
			res *= i;
		}
		return res;
	}
}
