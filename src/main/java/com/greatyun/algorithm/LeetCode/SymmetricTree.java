package com.greatyun.algorithm.LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode treeLeft, TreeNode treeRight) {
        if(treeLeft == null && treeRight == null) return true;
        if(treeLeft == null || treeRight == null) return false;
        if(treeLeft.val != treeRight.val) return false;
        if(!isSymmetric(treeLeft.left, treeRight.right) || !isSymmetric(treeLeft.right, treeRight.left)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SymmetricTree obj = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        TreeNode left_1 = new TreeNode(2);
        TreeNode right_1 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        root.left = left_1;
        root.right = right_1;

//        left_1.right = treeNode3;
        //left_1.right = treeNode4;

        //right_1.left = treeNode3;
//        right_1.right = treeNode3;

        System.out.println(obj.isSymmetric(root));
    }
}
