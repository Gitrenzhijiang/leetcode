package com.u11;

public class FactorialTrailingZero {

    public static void main(String[] args) {
        
    }
    public int trailingZeroes(int n) {
        int r = 0;
        while (n != 0) {
            r += n/5;
            n /= 5;
        }
        return r;
    }
    /*
                1[5]    
0   0   0   0   1[10]   
0   0   0   0   1[15]   
0   0   0   0   1[20]   
0   0   0   0   2[25]   5   ok
0   0   0   0   1[30]   
0   0   0   0   1[35]   
0   0   0   0   1[40]   
0   0   0   0   1[45]   
0   0   0   0   2[50]   10 ok
0   0   0   0   1[55]   
0   0   0   0   1[60]   
0   0   0   0   1[65]   
0   0   0   0   1[70]   
0   0   0   0   2[75]   15 ok
0   0   0   0   1[80]   
0   0   0   0   1[85]   
0   0   0   0   1[90]   
0   0   0   0   1[95]   
0   0   0   0   2[100]  20 ok
0   0   0   0   1[105]  
0   0   0   0   1[110]  
0   0   0   0   1[115]  
0   0   0   0   1[120]  
0   0   0   0   3[125]  5+5
0   0   0   0   1[130]  
0   0   0   0   1[135]  
0   0   0   0   1[140]  
0   0   0   0   1[145]  
0   0   0   0   2[150]  
0   0   0   0   1[155]  
0   0   0   0   1[160]  
0   0   0   0   1[165]  
0   0   0   0   1[170]  
0   0   0   0   2[175]  
0   0   0   0   1[180]  
0   0   0   0   1[185]  
0   0   0   0   1[190]  
0   0   0   0   1[195]  
0   0   0   0   2[200]
     */
    private int many(int n, int base) {
        int s = 0;
        while (n >= base) {
            n = n / 5;
            s++;
        }
        return s * (s-1) / 2;
    }
    
    public long nj(int n) {
        long ret = 1;
        for (int i = 2;i <= n;i++) {
            ret *= i;
        }
        return ret;
    }
    private int five(int n) {
        int r = 0;
        while (n % 5 == 0) {
            n = n / 5;
            r ++;
        }
        return r;
    }
}
