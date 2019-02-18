package com.u4;

public class ValidNumber {

	public static void main(String[] args) {
		System.out.println(new ValidNumber().isNumber("+0.3"));
	}
	public boolean isNumber(String s) {
		boolean num = false, numAfterE = true, dot = false, exp = false, sign = false;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
        	char c = s.charAt(i);
            if (c == ' ') {
                if (i < n - 1 && s.charAt(i+1) != ' ' && (num || dot || exp || sign)) return false;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != ' ') return false;
                sign = true;
            } else if (c >= '0' && c <= '9') {
                num = true;
                numAfterE = true;
            } else if (c == '.') {
                if (dot || exp) return false;
                dot = true;
            } else if (c == 'e') {
                if (exp || !num) return false;
                exp = true;
                numAfterE = false;
            } else return false;
        }
        return num && numAfterE;
    }
	
	private int isallnum(String s, int start) {
		for(int i = start;i < s.length();i++) {
			char c = s.charAt(i);
			if(c < '0' || c > '9') {
				if(!(i == start && (c == '-' || c == '+'))) {
					return i-1;
				}
			}
		}
		return s.length()-1;
	}

}
