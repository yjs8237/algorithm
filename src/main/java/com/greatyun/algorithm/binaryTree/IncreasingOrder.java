package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IncreasingOrder {
    Queue<Integer> queue = new LinkedList<>();
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        makeNode(root);
        TreeNode ret = new TreeNode(queue.poll());
        TreeNode temp = ret;
        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            TreeNode node = new TreeNode(poll);
            temp.right = node;
            temp = node;
        }

        //search(ret);
        return ret;
    }

    public void makeNode(TreeNode root) {
        if(root != null) {
            makeNode(root.left );
            queue.offer(root.val);
            makeNode(root.right );
        }
    }

    public TreeNode makeTree(int [] arr , int start , int end) {
        if(start <= end) {
            int mid = (start+end) / 2;
            TreeNode node = new TreeNode(arr[mid]);
            node.left = makeTree(arr , start , mid-1);
            node.right = makeTree(arr , mid+1 , end);
            return node;
        } else {
            return null;
        }
    }

    public void search(TreeNode root) {
        if(root != null) {
            search(root.left);
            System.out.print(" " + root.val);
            search(root.right);
        }
    }

    public static void main(String[] args) {
        IncreasingOrder obj = new IncreasingOrder();
        int [] arr = {1,2,3,4,5,6,7,8,9,10};



        TreeNode treeNode = obj.makeTree(arr, 0, arr.length - 1);
        obj.search(treeNode);
        System.out.println();
        obj.increasingBST(treeNode);

    }
}
