package com.greatyun.algorithm.LeetCode;

import java.util.Arrays;

public class ConstructBinarySearchTreefromPreorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if(root.val != preorder[i]) {
                makeLeetTree(root , preorder[i]);
            }
        }
        return root;
    }

    private void makeLeetTree(TreeNode root , int value) {

        while(root != null) {
            if(root.val > value) {
                if(root.left != null) {
                    root = root.left;
                } else {
                    TreeNode treeNode = new TreeNode(value);
                    root.left = treeNode;
                    break;
                }
            } else {
                if(root.right != null) {
                    root = root.right;
                } else {
                    TreeNode treeNode = new TreeNode(value);
                    root.right = treeNode;
                    break;
                }
            }
        }
        

    }

    private TreeNode makeLeetTreeLeet(int [] a , int start , int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode(a[start]);


    }

    public TreeNode makeTree(int [] a , int start , int end) {
        if(start > end) return  null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a[mid]);
        node.left = makeTree(a , start , mid - 1);
        node.right = makeTree(a , mid +1  , end);
        return node;
    }

    public void searchTree(TreeNode node , int find) {
        if(find < node.val) {
            System.out.println("data left node val : " + node.val);
            searchTree(node.left , find);
        } else if(find > node.val) {
            System.out.println("data right node val : " + node.val);
            searchTree(node.right , find);
        } else {
            System.out.println("data found " + node.val);
        }
    }


    public void inorder(TreeNode root) {
        if(root != null) {
            System.out.print("[" + root.val + "]");
            inorder(root.left);
            inorder(root.right);
        }
    }

    public void printNode(TreeNode root) {
        if(root != null) {
            System.out.println(root.val);
            printNode(root.left);
            printNode(root.right);
        }
    }


    public static void main(String [] args) {
        ConstructBinarySearchTreefromPreorderTraversal obj = new ConstructBinarySearchTreefromPreorderTraversal();
        int [] intarr = {8,5,1,7,10,12};
        TreeNode root = obj.makeTree(intarr, 0, intarr.length - 1);
//        obj.searchTree(root , 1);

        TreeNode treeNode = obj.bstFromPreorder(intarr);
        obj.printNode(treeNode);
//        obj.searchTree(treeNode , 3);

    }


}
