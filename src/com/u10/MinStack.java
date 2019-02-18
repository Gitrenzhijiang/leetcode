package com.u10;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
 * @author REN
 *
 */
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.
        System.out.println("=====");
        
    }
    /**
     * 初始化最小容量，只能是2的幂
     */
    private final static int INITIAL_MIN_CAPACITY = 8;
    
    transient int[] arr;
    /**
     * 最后一个元素的下一个的索引
     */
    transient int tail;
    
    int minIndex = -1;
    
    public MinStack() {
        arr = new int[INITIAL_MIN_CAPACITY];
        tail = 0;
    }
    
    public void push(int x) {
        
        arr[tail] = x;
        if (minIndex == -1) {
            minIndex = tail;
        }else if (arr[minIndex] > x){
            minIndex = tail;
        }
        tail++;
        if (isFull()) {
            doubleCapacity();
        }
    }
    
    public void pop() {
        checkIsEmpty();
        if (--tail == minIndex) {
            minIndex = getMinIndex(0, tail-1);
        }
    }
    
    public int top() {
        return arr[tail-1];
    }
    
    public int getMin() {
        checkIsEmpty();
        return arr[minIndex];
    }
    // find minIndex
    private int getMinIndex(int start, int end) {
        if (start > end) {
            return -1;
        }
        int ret = end;
        for (int i = end-1;i >= start;i--) {
            if (arr[i] < arr[ret]) {
                ret = i;
            }
        }
        return ret;
    }
    // 当前数组是否已经满
    private boolean isFull() {
        if (tail < arr.length) {
            return false;
        }
        return true;
    }
    // 检查当前栈是否为空，如果是则抛出异常
    private void checkIsEmpty() {
        if (tail <= 0) {
            throw new RuntimeException("the stack is empty");
        }
    }
    // 使当前容量扩大两倍
    private void doubleCapacity() {
        int[] a = new int[arr.length << 1];
        System.arraycopy(arr, 0, a, 0, tail);
        arr = a;
    }
    
}
