package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MergeTree {
    /**
     * 617. Merge Two Binary Trees
     * Easy
     *
     * Add to List
     * Share
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
     *
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
     *
     * Example 1:
     *
     * Input:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * Output:
     * Merged tree:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     *
     *
     * Note: The merging process must start from the root nodes of both trees.
     */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        return addNodes(t1, t2);
    }

    private TreeNode addNodes(TreeNode t1, TreeNode t2) {

        if(t1 == null && t2 == null) {
            return null;
        }

        if(t1 == null) return t2;
        if(t2 == null) return t1;

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = addNodes(t1.left , t2.left);
        node.right = addNodes(t1.right , t2.right);

        return node;
    }


    public static void main(String[] args) {
        MergeTree obj = new MergeTree();
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root1.left = node1;


        TreeNode root2 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root2.right = node2;

        obj.mergeTrees(root1 , root2);
    }



}
