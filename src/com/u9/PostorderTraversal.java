package com.u9;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n2.right = n3;
        List<Integer> ret = new PostorderTraversal().postorderTraversal(root);
        for (Integer r : ret) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> list = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        list.push(root);
        TreeNode head = null;
        while (!list.isEmpty()) {
            TreeNode node = list.peek();
            if ((node.right == null && node.left == null) || (node.left == head || node.right == head)) {
                ret.add(node.val);
                list.pop();
                head = node;
                continue;
            }
            if (node.right != null) {
                list.push(node.right);
            }
            if (node.left != null) {
                list.push(node.left);
            }
        }
        
        return ret;
    }
    private int find(List<TreeNode> list, List<Integer> buff) {
        for (int i = list.size()-1;i >= 0;i--) {
            if (buff.contains(i)) {
                continue;
            }
            buff.add(i);
            return i;
        }
        return -1;
    }
    
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 