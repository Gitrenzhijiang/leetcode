package com.u7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
public class ConstructBinaryTree {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] preorder = ConstructBinaryTree.MainClass.stringToIntegerArray(line);
            line = in.readLine();
            int[] inorder = ConstructBinaryTree.MainClass.stringToIntegerArray(line);
            
            TreeNode ret = new ConstructBinaryTree().buildTree(preorder, inorder);
            
            String out = ConstructBinaryTree.MainClass.treeNodeToString(ret);
            
            System.out.print(out);
        }
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    // 1 2 3
    // 2 3 1
    private TreeNode buildTree(int[] preorder, int[] inorder, int pre, int last, int in_start, int in_end) {
        TreeNode root = new TreeNode(preorder[pre]);
        //递归结束条件
        if (pre == last && in_start == in_end) {
            return root;
        }
        int i = 0;
        for(i = in_start;i <= in_end;i++) {
            if (preorder[pre] == inorder[i]) {
                break;
            }
        }
        // 有左子树的情况
        if (i != in_start) {
            root.left = buildTree(preorder, inorder, pre + 1, i - in_start + pre, in_start, i - 1);
        }

        // 生成右子树
        if (i != in_end) { 
            root.right = buildTree(preorder, inorder, i - in_start + pre + 1, last, i + 1, in_end);
        }
        return root;
    }
    
    public static class MainClass {
        public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
              return new int[0];
            }
        
            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for(int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }
        
        public static String treeNodeToString(TreeNode root) {
            if (root == null) {
                return "[]";
            }
        
            String output = "";
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);
            while(!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.remove();
        
                if (node == null) {
                  output += "null, ";
                  continue;
                }
        
                output += String.valueOf(node.val) + ", ";
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
            }
            return "[" + output.substring(0, output.length() - 2) + "]";
        }
        
    }
}
