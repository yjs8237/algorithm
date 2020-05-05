package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

public class DeepestLeavesSum {

    int ret = 0;
    int lev = 0;
    public int deepestLeavesSum(TreeNode root) {
       if(root == null) return 0;
       search(root , lev);
        System.out.println();
        System.out.println("ret : " + ret + " , level : " + lev);
       return ret;
    }

    public void search(TreeNode root , int level) {

        if(root == null) return;
        if(root.left == null && root.right == null) {
            System.out.println("val : " + root.val + " level : " + level);

            if(lev < level) {
                ret = root.val;
                lev = level;
            } else if(lev == level) {
                ret += root.val;
            }

        } else {
            search(root.left , level + 1);
            search(root.right , level + 1);
        }
    }

    public static void main(String[] args) {
        DeepestLeavesSum obj = new DeepestLeavesSum();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;
        node3.left = node6;
        node5.right = node7;

        System.out.println(obj.deepestLeavesSum(root));
    }
}
