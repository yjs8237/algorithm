package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

public class ConvertBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums , 0 , nums.length-1);
    }

    public TreeNode makeTree(int [] nums , int start , int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums , start , mid-1);
        node.right = makeTree(nums , mid+1 , end);
        return node;
    }
    public static void main(String[] args) {
        ConvertBinarySearchTree obj = new ConvertBinarySearchTree();
        int []arr = {1,2,3,4,5};
        obj.sortedArrayToBST(arr);
    }
}
