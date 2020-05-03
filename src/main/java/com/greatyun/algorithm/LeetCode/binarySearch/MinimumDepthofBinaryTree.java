package com.greatyun.algorithm.LeetCode.binarySearch;

public class MinimumDepthofBinaryTree {

    /**
     * 이진트리의 최소 depth 를 구하시오.
     */
    class Solution {
        public int minDepth(TreeNode root) {
            if(root==null)
                return 0;
            int left=minDepth(root.left);
            int right=minDepth(root.right);
            if(left==0 && right!=0 || left!=0 && right==0)
                return 1+Math.max(left,right);
            else
                return 1+Math.min(left,right);
        }
    }

}
