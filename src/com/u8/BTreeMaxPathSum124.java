package com.u8;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 
 * 1 / \ 2 3
 * 
 * 输出: 6
 * 
 * @author renzhijiang
 *
 */
public class BTreeMaxPathSum124 {

    public static void main(String[] args) {

    }
    // 一个更好的思路:递归函数返回值为:以当前结点为根,到叶结点的最大路径的和
//    public int maxPathSum1(TreeNode root, Integer res) {
//        if (root == null) {
//            return 0;
//        }
//        int r1 = Math.max(maxPathSum1(root.left, res), 0);
//        int r2 = Math.max(maxPathSum1(root.right, res), 0);
//        res = Math.max(res, r1 + r2 + root.val);
//        return Math.max(r1, r2) + root.val;
//    }
    
    
    
    
    
    
    public int maxPathSum(TreeNode root) {
        // 做一个选择, 根节点要不要加入路径中?
        return max0(root);
    }
    private int max0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 不包括root的最大路径和
        Integer max = null;
        if (root.left != null) {
            max = max0(root.left);
        }
        if (root.right != null) {
            if (max == null){
                max = max0(root.right);
            }else{
                max = Math.max(max, max0(root.right));
            }
        }
        // 包括root
        int incMax = max1(root, 2);
        return max == null?incMax:Math.max(incMax, max);
    }
    /**
     * 包括root的最大路径和
     * @param root
     * @return
     */
    private int max1(TreeNode root, int e) {
        if (root == null) {
            return 0;
        }
        int k1 = max1(root.left, 1);
        int k2 = max1(root.right, 1);
        int curMax = Math.max(k1, k2);
        if (e < 2) {
            return root.val + Math.max(curMax, 0);
        }else {
            return root.val + Math.max(0, k1) + Math.max(k2, 0);
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