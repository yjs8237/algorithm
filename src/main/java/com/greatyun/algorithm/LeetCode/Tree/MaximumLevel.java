package com.greatyun.algorithm.LeetCode.Tree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * Medium
 *
 * 392
 *
 * 19
 *
 * Add to List
 *
 * Share
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 */
public class MaximumLevel {

    public static int sol (TreeNode root) {
        int ret = 0;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int max = Integer.MIN_VALUE;
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum+=poll.val;
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
            if(sum > max) {
                max = sum;
                ret = depth;
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }


}
