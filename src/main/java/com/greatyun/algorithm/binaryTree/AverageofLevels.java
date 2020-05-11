package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevels {

    /**
     * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     * Example 1:
     * Input:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * Output: [3, 14.5, 11]
     * Explanation:
     * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
     */


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int size = queue.size();

            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
            }
            ret.add(sum / (double) size);
        }
        return ret;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;
        node3.left = node6;
        node5.right = node7;

        //[2147483647,2147483647,2147483647]

        System.out.println(2147483647 * 2);
        System.out.println(2147483647 * 2 / (double) 2);
    }
}
