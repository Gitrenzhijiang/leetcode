package com.u11;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.w3c.dom.Node;

/**
 * 二叉搜索树的 迭代器
 * @author REN
 */
public class BSTIterator {
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(15);
        node1.right.left = new TreeNode(9);
        node1.right.right = new TreeNode(20);
        BSTIterator iterator2 = new BSTIterator(node1);
        
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
    private TreeNode root;
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        inStack(root);
    }
    
    /** 
     * @return the next smallest number 
     * 使用O(h)的空间，O(1)的时间复杂度
     * */
    public int next() {
        TreeNode min = stack.pop();
        inStack(min.right);
        return min.val;
    }
    
    /** 
     * @return whether we have a next smallest number 
     * 使用O(h)的空间，O(1)的时间复杂度
     * */
    public boolean hasNext() {
        return 0 != stack.size;
    }
    
    private void inStack(TreeNode node) {
        TreeNode t = node;
        while (t != null) {
            stack.push(t);
            t = t.left;
        }
    }
    static class Stack<T>{
        T arr[];
        int size = 0;
        public Stack() {
            arr = (T[]) new Object[16];
        }
        public T pop() {
            return arr[--size];
        }
        public void push(T t) {
            if (size >= arr.length) {
                doubleCapacity();
            }
            arr[size++] = t;
        }
        private void doubleCapacity() {
            arr = Arrays.copyOf(arr, arr.length*2);
        }
    }
    
}
