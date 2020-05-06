package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

public class SearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if( root == null ) return null;
        if(root.val == val) {
            return root;
        } else if(root.val > val) {
            return searchBST(root.left , val);
        } else if(root.val < val) {
            return searchBST(root.right , val);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
