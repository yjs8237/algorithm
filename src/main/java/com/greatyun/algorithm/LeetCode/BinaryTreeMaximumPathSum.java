package com.greatyun.algorithm.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxPathSum(TreeNode root) {
        int sum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<String , Integer> map = new HashMap<>();
        map.put("sum" , root.val);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) continue;
            if(node.left != null || node.right != null) {

                if(node.left == null && node.right != null) {
                    sum = getMaxValue(node.val , node.right.val);
                } else if( node.left != null && node.right == null) {
                    sum = getMaxValue(node.val , node.left.val);
                } else {
                    int in1 = node.val < 0 ? 0 : node.val;
                    int in2 = node.left.val < 0 ? 0 : node.left.val;
                    int in3 = node.right.val < 0 ? 0 : node.right.val;
                    sum = in1 + in2 + in3;
                }
                map.put("sum" , sum);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return map.get("sum");
    }

    private int getMaxValue(int val, int val1) {
        if(val < 0 && val1 < 0) {
            return Math.max(val , val1);
        } else if(val >= 0 && val1 >= 0) {
            return val + val1;
        } else {
            return Math.max(val , val1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left_1 = new TreeNode(2);
        TreeNode right_1 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);

        root.left = left_1;
        root.right = right_1;
//        right_1.left = treeNode3;
//        right_1.right = treeNode4;

        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        System.out.println(obj.maxPathSum(root));

    }
}
