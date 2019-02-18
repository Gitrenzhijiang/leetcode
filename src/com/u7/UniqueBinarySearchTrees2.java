package com.u7;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees2 {

    public static void main(String[] args) {
        UniqueBinarySearchTrees2 ubs2 = new UniqueBinarySearchTrees2();
        int n = 3;
        
        TimeUtils.start();
        List<TreeNode> res = ubs2.unibs(n);
        TimeUtils.over(true);
        System.out.println(res.size());
        
        TimeUtils.start();
        List<TreeNode> res2 = ubs2.unibs_fdg(n);
        TimeUtils.over(true);
        System.out.println(res2.size());
    }
    public List<TreeNode> unibs(int n){
        List<TreeNode>[][]dp = new ArrayList[n+1][n+1];
        for (int i = 0;i < n+1;i++) {
            dp[i] = new ArrayList[n+1];
        }
        List<TreeNode> res = unibs0(dp, 1, n);
        return res;
    }
    // 从n 除去 buff中的, 选出一个当头, 递归左孩子和右孩子子树
    private List<TreeNode> unibs0(List<TreeNode>[][]dp, int left, int right){
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            return res;
        }
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        //第一次运算
        if(left == right) {
            res.add(new TreeNode(left));
            dp[left][right] = res;
            return res;
        }
        
        // right > left
        for (int i = left;i <= right;i++) {
            List<TreeNode> lefts = unibs0(dp, left, i - 1);
            List<TreeNode> rights = unibs0(dp, i + 1, right);
            if (rights.size() == 0) {
                for (TreeNode leftNode : lefts) {
                    TreeNode head = new TreeNode(i);
                    head.left = leftNode;
                    res.add(head);
                }
            }else if(lefts.size() == 0) {
                for (TreeNode rightNode : rights) {
                    TreeNode head = new TreeNode(i);
                    head.right = rightNode;
                    res.add(head);
                }
            }else {
                for (TreeNode leftNode : lefts) {
                    for (TreeNode rightNode : rights) {
                        TreeNode head = new TreeNode(i);
                        head.left = leftNode;
                        head.right = rightNode;
                        res.add(head);
                    }
                }
            }
        }
        dp[left][right] = res;
        return res;
    }
    
    /**
     * 自底向上动态规划求解
     * @param n
     * @return
     */
    public List<TreeNode> unibs_fdg(int n){
        List<TreeNode>[][] dp = new List[n+1][n+1];
        // 1-n
        // 1-1  1-2
        for (int i = 0;i < n+1;i++) {
            dp[i] = new List[n+1];
        }
        for (int len = 1;len <= n;len++) {
            for (int i = 1;i <= n - len + 1;i++) {
                int j = i + len - 1;
                List<TreeNode> res = new ArrayList<>();
                if (i == j) {
                    res.add(new TreeNode(i));
                    dp[i][j] = res;
                    continue;
                }
                for (int k = i;k <= j;k++) {
                    List<TreeNode> lefts = null;
                    if (k != i) {
                        lefts = dp[i][k - 1];
                    }
                    List<TreeNode> rights = null;
                    if (k != j) {
                        rights = dp[k + 1][j];
                    }
                    if (lefts == null) {
                        for (TreeNode rightNode : rights) {
                            TreeNode head = new TreeNode(k);
                            head.right = rightNode;
                            res.add(head);
                        }
                    }else if(rights == null) {
                        for (TreeNode leftNode : lefts) {
                            TreeNode head = new TreeNode(k);
                            head.left = leftNode;
                            res.add(head);
                        }
                    }else {
                        for (TreeNode leftNode : lefts) {
                            for (TreeNode rightNode : rights) {
                                TreeNode head = new TreeNode(i);
                                head.left = leftNode;
                                head.right = rightNode;
                                res.add(head);
                            }
                        }
                    }
                }
                dp[i][j] = res;
            }
        }
        return dp[1][n];
    }
    
    
    
    
    
    
    
    public void printTree(TreeNode root) {
        if (root != null){
            
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
    
    
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}