package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    /**
     * Tree 를 root 기준 하위 자식을 위치를 reverse 시켜라
     * Invert a binary tree.
     *
     * Example:
     *
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * Output:
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     */
    /*
    public TreeNode invertTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
        }
        return root;
    }
     */

    public TreeNode invertTree(TreeNode root) {
        if(root != null) {
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

    public void search(TreeNode root) {
        if(root != null) {
            System.out.print(" " + root.val);
            search(root.left);
            search(root.right);
        }
    }

    public static void main(String[] args) {
        InvertTree obj = new InvertTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node2.right = node4;
        obj.search(root);
        System.out.println("-------------------------");
        obj.invertTree(root);
        System.out.println("-------------------------");
        obj.search(root);
    }
}
