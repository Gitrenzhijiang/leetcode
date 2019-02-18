package com.u4;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(6, 8));
		Interval newInterval = new Interval(6, 8);
		List<Interval> res = new InsertInterval().insert(intervals, newInterval);
		System.out.print("[");
		for(Interval interval:res) {
			System.out.print("["+interval.start + "," + interval.end+"]");
		}
		System.out.println("]");
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int tag = -1;
        int end_i = -1;
        for(int i = 0;i < intervals.size();i++){
            Interval temp = intervals.get(i);
            if(tag == -1 && newInterval.start < temp.start){
                intervals.add(i, newInterval);
                tag = i;
            }else if(tag == -1 && newInterval.start >= temp.start && newInterval.start <= temp.end){
                temp.start = Math.min(newInterval.start, temp.start);
                tag = i;
            }else if(tag != -1 && newInterval.end < temp.start) {
                end_i = i-1;
                break;
            }else if(tag != -1 && newInterval.end >= temp.start && newInterval.end <= temp.end){
          end_i = i;
                break;
            }
        }
        if(tag == -1) {
        	intervals.add(newInterval);
            return intervals;
        }
        if(end_i == -1)
            end_i = intervals.size()-1;
        intervals.get(tag).end = Math.max(intervals.get(end_i).end, newInterval.end);
        //ÒÆ³ý
        for(int i = tag+1;i <= end_i;i++){
            intervals.remove(tag+1);
        }
        
        return intervals;
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}