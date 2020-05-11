package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumofRoot {
    List<String> list = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {

        //inorder(root);
        sumRootToLeaf(root , "");
        int ret = 0;
        for (String str : list) {
            ret += Integer.parseInt(str, 2);
        }
        return ret;
    }

    public void sumRootToLeaf(TreeNode root , String sub) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            list.add(sub + String.valueOf(root.val));
        }
        sumRootToLeaf(root.left , sub + String.valueOf(root.val));
        sumRootToLeaf(root.right , sub + String.valueOf(root.val));
    }

    public void inorder(TreeNode root) {
        if(root == null) return;

        System.out.print(" " + root.val);
        inorder(root.left);
        inorder(root.right);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(8);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        SumofRoot obj = new SumofRoot();
        System.out.println(obj.sumRootToLeaf(root));
    }
}
