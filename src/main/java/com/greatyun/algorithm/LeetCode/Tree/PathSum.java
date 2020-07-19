package com.greatyun.algorithm.LeetCode.Tree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 437. Path Sum III
 * Easy
 *
 * 3455
 *
 * 296
 *
 * Add to List
 *
 * Share
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSum {
    public static int sol (TreeNode root , int sum) {

        int ret = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>();
                TreeNode node = queue.poll();
                int tempSum = node.val;
                list.add(tempSum);
                if(tempSum == sum) {
                    ret++;
                } else {

                    TreeNode tempNode = node.left;
                    while(tempNode != null) {
                        tempSum += tempNode.val;
                        list.add(tempNode.val);
                        if(tempSum == sum) {
                            ret++;
                            for (int j = 0; j < list.size(); j++) {
                                System.out.print(list.get(j) + " ");
                            }
                            break;
                        } else if(tempSum > sum) {
                            break;
                        } else {
                            tempNode = tempNode.left;
                        }
                    }

                    list = new ArrayList<>();
                    tempSum = node.val;
                    tempNode = node.right;
                    while(tempNode != null) {
                        tempSum += tempNode.val;
                        list.add(tempNode.val);
                        if(tempSum == sum) {
                            ret++;
                            for (int j = 0; j < list.size(); j++) {
                                System.out.print(list.get(j) + " ");
                            }
                            break;
                        } else if(tempSum > sum) {
                            break;
                        } else {
                            tempNode = tempNode.right;
                        }
                    }
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        //System.out.println(ret);
        return ret;
    }

    public static void dfs(TreeNode root , int sum) {

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println((-3 + 11));
        PathSum.sol(root , 4);

        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println(now);
    }
}
