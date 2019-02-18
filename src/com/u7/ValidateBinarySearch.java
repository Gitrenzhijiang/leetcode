package com.u7;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 */
public class ValidateBinarySearch {

    public static void main(String[] args) {
        
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST0(root, new ArrayList<>());
    }
    // 一颗树的中序遍历, 
    public boolean isValidBST0(TreeNode root, List<Integer> res) {
        if (root != null) {
            boolean leftTag = isValidBST0(root.left, res);
            if (leftTag == false) {
                return false;
            }
            if(!res.isEmpty() && res.remove(res.size()-1) >= root.val) {
                return false;
            }
            res.add(root.val);
            return isValidBST0(root.right, res);
        }
        return true;
    }
    
    
}
