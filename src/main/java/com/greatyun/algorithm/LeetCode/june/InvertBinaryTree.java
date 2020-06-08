package com.greatyun.algorithm.LeetCode.june;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {


    public TreeNode invertTree(TreeNode root) {

        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode temp = null;
                if(poll.left != null && poll.right != null) {
                    temp = poll.left;
                    poll.left = poll.right;
                    poll.right = temp;

                    queue.offer(poll.left);
                    queue.offer(poll.right);
                } else if(poll.left != null) {
                    poll.right = poll.left;
                    poll.left = null;
                    queue.offer(poll.right);
                } else if(poll.right != null) {
                    poll.left = poll.right;
                    poll.right = null;
                    queue.offer(poll.left);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree obj = new InvertBinaryTree();

        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        obj.invertTree(root);
    }
}
