package com.u11;

import java.util.ArrayDeque;
import java.util.Deque;

import org.w3c.dom.Node;

/**
 * 二叉搜索树的 迭代器
 * @author REN
 */
public class BSTIterator1 {
    
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        node1.left = new TreeNode(3);
        node1.right = new TreeNode(15);
        node1.right.left = new TreeNode(9);
        node1.right.right = new TreeNode(20);
        BSTIterator1 iterator = new BSTIterator1(node1);
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    private TreeNode root;
    private Deque<TreeNode> stack;
    public BSTIterator1(TreeNode root) {
        this.root = root;
        stack = new ArrayDeque<>();
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
        return !stack.isEmpty();
    }
    
    private void inStack(TreeNode node) {
        if (node == null) {
            return;
        }
        stack.push(node);
        inStack(node.left);
    }
}
