package com.greatyun.algorithm.LeetCode.Tree;

public class SameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Value {
        String data;
        Value(String data) {
            this.data = data;
        }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        String s1 = searchNode(p, new Value(""));
        String s2 = searchNode(q, new Value(""));
        return s1.equals(s2);
    }

    public String searchNode(TreeNode node , Value value) {
        if(node != null) {
            value.data += String.valueOf(node.val);
            searchNode(node.left , value);
            searchNode(node.right , value);
        } else {
            value.data += "null";
        }
        return value.data;
    }

    public static void main(String [] args) {
        SameTree sameTree = new SameTree();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);

        node1.left = node2;

        node3.left = null;
        node3.right = node2;

        boolean isSame = sameTree.isSameTree(node1 , node3);
        System.out.println("isSame : " + isSame);
    }

}
