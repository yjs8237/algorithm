package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public int level = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {

        return null;
    }

    public List<List<Integer>> levelOrder(TreeNode root , int level) {
        if(root != null) {
            System.out.println(root.val + " , " + level);
            levelOrder(root.left , level + 1);
            levelOrder(root.right , level + 1);
        }
        return null;
    }


    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
        
    }
}
