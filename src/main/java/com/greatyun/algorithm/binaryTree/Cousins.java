package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.HashMap;

public class Cousins {

    /**
     *In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
     *
     * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
     *
     * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
     *
     * Return true if and only if the nodes corresponding to the values x and y are cousins.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,3,4], x = 4, y = 3
     * Output: false
     *
     */
    class Remember {
        int depth;
        TreeNode parent;
    }
    TreeNode prev_node;
    HashMap<Integer , Remember> map = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        search(root , root , 0 , x , y);

        Remember rem_x = map.get(x);
        Remember rem_y = map.get(y);

        System.out.println(rem_x.depth + " " + rem_x.parent.val);
        System.out.println(rem_y.depth + " " + rem_y.parent.val);

        if(!rem_x.parent.equals(rem_y.parent) && rem_x.depth == rem_y.depth) {
            return true;
        } else {
            return false;
        }
    }

    public void search(TreeNode root, TreeNode parent, int depth , int x, int y) {
        if(root != null) {
            if(root.val == x) {
                Remember remember = new Remember();
                remember.depth = depth;
                remember.parent = parent;
                map.put(x , remember);
            } else if(root.val == y) {
                Remember remember = new Remember();
                remember.depth = depth;
                remember.parent = parent;
                map.put(y , remember);
            }
            search(root.left , root, depth + 1 , x , y);
            search(root.right , root, depth + 1,  x , y);
        }
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
        TreeNode node8 = new TreeNode(9);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;
        node3.left = node6;
        node5.right = node7;

        Cousins obj = new Cousins();
        System.out.println(obj.isCousins(root , 1, 1));

    }
}
