package com.u4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Mypow {

	public static void main(String[] args) {
		double x = 1.00001;
		int n = 12345678;
		Mypow mypow = new Mypow();
		System.out.println("answer:"+mypow.myPow3(x, n));
		System.out.println("answer:" + Math.pow(x, n));
	}
	public double myPow(double x, int n) {
		if(n == 0)return 1.0;
		int length = Math.abs(n);
		BigDecimal num = new BigDecimal(""+x);
		BigDecimal syu = null;
		while(length >= 2) {
			if(length % 2 != 0){
				if(syu == null)
					syu = new BigDecimal(num.toString());
				else {
					syu = syu.multiply(num);
				}
			}
			num = num.multiply(num);
			length = length / 2;
		}
		//计算最终结果
		if(syu != null) {
			num = num.multiply(syu);
		}
		if(n < 0) {
			BigDecimal one = new BigDecimal("1.0");
			try {
				num = one.divide(num);
			}catch(Exception e) {
				num = one.divide(num, 16, RoundingMode.HALF_DOWN);
			}
		}
		return num.doubleValue();
	}
	
	public double myPow2(double x, int n) {
		if(n > 0)
			return pow0(x, n);
		else {
			return 1.0 / pow0(x, -n);
		}
	}
	private double pow0(double x, int n) {
		if(n == 0) {
			return 1.0;
		}
		double half = pow0(x, n / 2);
		if(n % 2 != 0) {
			return x * half * half;
		}else {
			return half * half;
		}
	}
	
	public double myPow3(double x, int n) {
		if(n == 0)return 1.0;
		int length = Math.abs(n);
		double num = x;
		double syu = 0;
		while(length >= 2) {
			if(length % 2 != 0){
				if(syu == 0)
					syu = num;
				else {
					syu = syu * num;
				}
			}
			num = num * num;
			length = length / 2;
		}
		//计算最终结果
		if(syu != 0.0) {
			num = num * syu;
		}
		if(n < 0) {
			num = 1/num;
		}
		return num;
	}
}