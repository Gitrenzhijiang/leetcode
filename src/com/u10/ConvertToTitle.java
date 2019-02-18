package com.u10;

public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(new ConvertToTitle().convertToTitle(53)); //
    }
    public String convertToTitle(int n) {
        
        StringBuilder sb =  new StringBuilder();
        // 27
        while (n != 0) {
            n--;
            int yu = n % 26;
            
            
            n = n / 26;
            sb.insert(0, cs[yu]);
        }
        return sb.toString();
    }
    private char[] cs = {'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    // A->1  B->2   Z->26  AA-> 27  AB->28
}
