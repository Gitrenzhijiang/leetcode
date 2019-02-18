package com.u8;
/**在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1:

输入: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3
*/
public class LT134 {
    
    public static void main(String[] args) {

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        for (int i = 0;i < gas.length;i++) {
            int start = i;
            int capacity = 0;
            while (goNext(gas, cost, start, capacity)) {
                
                capacity = gas[start] + capacity - cost[start];
                start++;
                start = start % cost.length;
                if (start == i) {
                    // 回到了起点, 只存在一个解
                    return i;
                }
            }
        }
        return -1;
    }
    // 从start出发到下一站能否到达, capacity是现有的油量
    private boolean goNext(int[] gas, int[] cost, int start, int capacity) {
        return gas[start] + capacity >= cost[start]? true : false;
    }
}
