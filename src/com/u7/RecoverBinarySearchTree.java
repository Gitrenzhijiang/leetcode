package com.u7;

import java.util.ArrayList;
import java.util.List;

/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4             1  3  2  4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        
    }
    /**
     * 思路, 通过中序遍历, 应该可以找到循序错乱的两个数, 使用log(n)+o(n)的时间
     * 再替换之
     * @param root
     */
    public void recoverTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        order(root, res, c);
        if (c.size() == 2) {
            findAndChange(root, res.get(c.get(0) - 1), res.get(c.get(1)));
        }else if(c.size() == 1){
            findAndChange(root, res.get(c.get(0) - 1), res.get(c.get(0)));
        }
    }
    // 中序遍历 二叉搜索树, 将结果依次存储 
    private void order(TreeNode root, List<Integer> res, List<Integer> c) {
        if (root != null) {
            order(root.left, res, c);
            if (!res.isEmpty() && res.get(res.size()-1) > root.val) {
                c.add(res.size());
            }
            res.add(root.val);
            order(root.right, res, c);
        }
    }
    private void findAndChange(TreeNode root, int r, int t) {
        if (root != null) {
            findAndChange(root.left, r, t);
            if (root.val == r) {
                root.val = t;
            }else if(root.val == t) {
                root.val = r;
            }
            findAndChange(root.right, r, t);
        }
    }
}
