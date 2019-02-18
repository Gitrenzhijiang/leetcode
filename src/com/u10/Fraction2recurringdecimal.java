package com.u10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:
 能用分数表示的数一定是 有理数,
无理数指的是 Π， 黄金比例等
输入: numerator = 1, denominator = 2
输出: "0.5"
 */
public class Fraction2recurringdecimal {
    public static void main(String[] args) {
        System.out.println(new Fraction2recurringdecimal().fractionToDecimal(-1, 
                -2147483648));
        
        System.out.println(~2);
    }
    // 我们可以用的 4 / 7      拿到下一个分子的变动,拿到下一步商的变动
    /**
     * 问题在于数字容量(int)
     * 0.1(6) 这种情况
     * 缓存余数->pos
     * 判断 - 的插入
     * 技巧：每一次都是 新余数=(余数*10)%除数    上去的数= (余数*10)%除数
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        long n = Math.abs(((long)numerator));
        long d =  Math.abs(((long)denominator));
        int tag = (numerator ^ denominator) >>> 31; // 0 是正数， 1 是负数;
        long yu = n % d;
        long out = n / d;
        Map<Long, Integer> m = new HashMap<>();
        String res = String.valueOf(out);
        if (tag == 1 && (out > 0 || yu > 0)) {
            res = "-" + res;
        }
        if (yu == 0) {
            return res;
        }
        res += ".";
        List<String> s = new ArrayList<>();
        int pos = 0;
        while (yu != 0) {
            if (m.containsKey(yu)) {
                s.add(m.get(yu), "(");
                s.add(")");
                return res+toString(s);
            }
            m.put(yu, pos);
            s.add((yu*10) / d + "");
            yu = (yu * 10) % d;
            pos++;
        }
        return res+toString(s);
    }
    public String toString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    
}
