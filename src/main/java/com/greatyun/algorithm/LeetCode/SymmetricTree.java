package com.greatyun.algorithm.LeetCode;

import java.util.*;

public class SymmetricTree {

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

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode treeLeft, TreeNode treeRight) {
        if(treeLeft == null && treeRight == null) return true;
        if(treeLeft == null || treeRight == null) return false;
        if(treeLeft.val != treeRight.val) return false;
        if(!isSymmetric(treeLeft.left, treeRight.right) || !isSymmetric(treeLeft.right, treeRight.left)) {
            return false;
        }
        return true;
    }
    Integer max_depth = 1;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        stack.push(root);

        while(!stack.empty()) {
            boolean isDepth = false;
            TreeNode node = stack.pop();
            if(node.left != null) {
                stack.push(node.left);
                isDepth = true;
            }
            if(node.right != null) {
                stack.push(node.right);
                isDepth = true;
            }
            if(isDepth && !set.contains(node.val)) {
                max_depth++;
                set.add(node.val);
            }
        }
        return max_depth;
    }

    class Depth {
        int depth;
    }
    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<TreeNode> nodeList = new ArrayList<>();
        if(root.left != null) {
            nodeList.add(root.left);
        }
        if(root.right != null) {
            nodeList.add(root.right);
        }
        int depth = 1;
        while(nodeList.size()>0) {
            List<TreeNode> tempList = nodeList;
            nodeList = new ArrayList<>();
            for (TreeNode node : tempList) {
                if(node.left != null) nodeList.add(node);
                if(node.right != null) nodeList.add(node);
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth1(TreeNode root) {
        return root == null ? 0  // Base case : starting at the (proverbial) children of the leaves
                : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int checkDepth(TreeNode root , int level) {
        if(root != null) {
            checkDepth(root.left , level + 1);
            checkDepth(root.right , level + 1);
        }
        max_depth = level;
        return level;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()) {
            List<Integer> innerList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                innerList.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ret.add(0 , innerList);
            System.out.println();
        }

        return ret;
    }

    public static void main(String[] args) {
        SymmetricTree obj = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        TreeNode left_1 = new TreeNode(2);
        TreeNode right_1 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);

        root.left = left_1;
        root.right = right_1;

        left_1.left = treeNode3;
        left_1.right = null;

        right_1.left = null;
        right_1.right = treeNode4;


        System.out.println(obj.levelOrderBottom(root));
    }
}
