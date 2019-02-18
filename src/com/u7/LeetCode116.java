package com.u7;

import java.util.Deque;
import java.util.LinkedList;

/*
给定一个二叉树

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

说明:

你只能使用额外常数空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
示例:

给定完美二叉树，

     1
   /  \
  2    3
 / \  / \
4  5  6  7
调用你的函数后，该完美二叉树变为：

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

 */
public class LeetCode116 {

    public static void main(String[] args) {
        
    }
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeLinkNode> queue = new LinkedList();
        queue.addLast(root);
        // 下一层的结点数量, 当前层结点剩余数量
        int count = 0, lastcount = 1;
        // 当前层, next结点
        TreeLinkNode nextNode = null;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.removeFirst();
            node.next = nextNode;
            nextNode = node;// 可能不是这一层的
            lastcount--;
            if (node.right != null) {
                queue.addLast(node.right);
                count++;
            }
            if (node.left != null) {
                queue.addLast(node.left);
                count++;
            }
            if (lastcount == 0) {
                lastcount = count;
                count = 0;
                nextNode = null;
            }
        }
        
    }
}

// Definition for binary tree with next pointer.
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}
