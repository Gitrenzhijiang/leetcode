package com.u7;

public class TimeUtils {
	private static long time = 0;
	/**
	 * ���ü�������ʱ��
	 */
	public static void reset() {
		time = 0;
	}
	/**
	 * ��ʼ��ʱ
	 */
	public static void start() {
		time = System.nanoTime();
	}
	/**
	 * ������ʱ
	 */
	public static void over(boolean toZero) {
		time = (System.nanoTime() - time);
		print();
		if(toZero)
			time = 0;
	}
	public static void print() {
		System.out.println("cost: " + time/1000000 + " ms");
	}
}
