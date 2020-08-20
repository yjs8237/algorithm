package com.greatyun.algorithm.LeetCode.Tree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * Medium
 *
 * 3397
 *
 * 141
 *
 * Add to List
 *
 * Share
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        ret.add(root.val);
        dfs(ret , root);
        ret.remove(ret.size()-1);
        return ret;
    }

    public void dfs(List<Integer> list , TreeNode root) {
        if(root == null) return;
        dfs(list , root.left);
        list.add(root.val);
        dfs(list , root.right);
    }
    public static void main(String[] args) {

    }
}
