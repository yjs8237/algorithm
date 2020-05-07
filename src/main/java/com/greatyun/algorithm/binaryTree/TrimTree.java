package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

public class TrimTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root != null) {



        }
        return root;
    }

    public void trim(TreeNode root, TreeNode parent , int L, int R) {
        if(root != null) {

            if(root.val < L || root.val > R) {

            }

            trim(root.left , root , L , R);
            trim(root.right , root , L , R);
        }
    }

    public static void main(String[] args) {
        /**
         *              1
         *           /    \
         *          2     3
         *        /  \   / \
         *       4   5  6  7
         *
         */


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

        node2.left = node5;
        node2.right = node6;

    }

}
