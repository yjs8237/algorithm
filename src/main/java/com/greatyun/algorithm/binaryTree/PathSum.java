package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

public class PathSum {

    Integer subSum = 0;
    /*
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        } if (root.left == null && root.right == null && root.val == sum) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
     */

    public boolean hasPathSum(TreeNode root, int sum) {
        return search(root , 0 , sum);
    }

    public boolean search(TreeNode root , int subSum , int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && subSum + root.val == sum) return true;

        return search(root.left , subSum + root.val , sum) || search(root.right , subSum + root.val , sum);
    }

    public int maxSum(TreeNode root) {
        maxSum(root , 0);
        System.out.println(max);
        return max;
    }

    Integer max = Integer.MIN_VALUE;
    public void maxSum(TreeNode root , int sum) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null && sum + root.val > max) {
            max = sum + root.val;
        }
        maxSum(root.left , sum + root.val);
        maxSum(root.right , sum + root.val);
    }


    public static void main(String[] args) {
        PathSum obj = new PathSum();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(9);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node5;

        node2.left = node4;

        //System.out.println(obj.hasPathSum(root , 7));
//        System.out.println(obj.maxSum(root));
    }
}
