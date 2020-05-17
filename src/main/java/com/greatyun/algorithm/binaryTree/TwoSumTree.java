package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TwoSumTree {


    /**
     *
     * Two Sum IV - Input is a BST
     * Easy
     *
     * 1320
     *
     * 133
     *
     * Add to List
     *
     * Share
     * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
     *
     * Example 1:
     *
     * Input:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 9
     *
     * Output: True
     *
     *
     * Example 2:
     *
     * Input:
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * Target = 28
     *
     * Output: False
     */

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        originRoot = root;
        return help(root , k);
    }

    public boolean help(TreeNode root , int k) {
        if(root == null) return false;
        if(searchSum(originRoot , root.val , k)) {
            return true;
        }
        return help(root.left , k) || help(root.right , k);
    }

    TreeNode originRoot;
    public boolean searchSum(TreeNode root , int target , int k) {
        if(root == null) return false;
        if(root.val != target && root.val + target == k) {
            return true;
        }
        return searchSum(root.left , target , k) || searchSum(root.right , target , k);
    }

    public static void main(String[] args) {
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
        TwoSumTree obj = new TwoSumTree();
        System.out.println(obj.findTarget(root , 3));
    }
}
