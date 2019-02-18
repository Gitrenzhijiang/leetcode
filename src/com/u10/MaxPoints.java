package com.u10;

import java.util.HashMap;
import java.util.Map;

public class MaxPoints {

	public static void main(String[] args) {
	    
	}
	/**
	 * 思路: 两个点相同， 斜率不存在
	 * @param points
	 * @return
	 */
	public int maxPoints(Point[] points) {
	    int res = 0;
	    for (int i = 0;i < points.length;i++) {
	        int same = 1;
	        Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
	        for (int j = i + 1;j < points.length;j++) {
	            if (points[i].x == points[j].x && points[i].y == points[j].y) {
	                same++;
	                continue;
	            }
	            int diff_x = points[i].x - points[j].x;
	            int diff_y = points[i].y - points[j].y;
	            
	        }
	    }
	    return res;
	}
	// 最大公约数
	private int gcb(int a, int b) {
	    while (b != 0) {
	        int t = b;
	        b = a % b;
	        a = t;
	    }
	    return a;
	}
}

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}