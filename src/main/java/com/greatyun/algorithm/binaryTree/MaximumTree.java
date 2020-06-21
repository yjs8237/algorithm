package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

public class MaximumTree {

    /**
     * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
     *
     * The root is the maximum number in the array.
     * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
     * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
     * Construct the maximum tree by the given array and output the root node of this tree.
     *
     * Example 1:
     * Input: [3,2,1,6,0,5]
     * Output: return the tree root node representing the following tree:
     *
     *       6
     *     /   \
     *    3     5
     *     \    /
     *      2  0
     *        \
     *         1
     * Note:
     * The size of the given array will be in the range [1,1000].
     */


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = makeTree(nums , 0 , nums.length);
        return root;
    }

    public TreeNode makeTree(int [] nums , int left , int right) {

        if(left == right) return null;

        // 1. 최대 값을 찾아 그 index의 왼쪽 기준 최대값은 left 노드 , 오른쪽 기준 최대값은 right 노드
        int index = findMax(nums , left , right);
        TreeNode root = new TreeNode(nums[index]);
        root.left = makeTree(nums , left , index);
        root.right = makeTree(nums , index+1 , right);

        return root;
    }

    private int findMax(int[] nums, int left, int right) {
       int retIndex = left;
        for (int i = left; i < right; i++) {
            if(nums[retIndex] < nums[i]) {
                retIndex=i;
            }
        }
        return retIndex;
    }

    public void searchNode(TreeNode root) {
        if(root != null) {
            System.out.println(root.val);
            searchNode(root.left);
            searchNode(root.right);
        }
    }


    public static void main(String[] args) {
        int [] arr = {3,2,1,6,0,5};
        MaximumTree obj = new MaximumTree();
        TreeNode root = obj.constructMaximumBinaryTree(arr);
        obj.searchNode(root);
    }
}
