package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its level order traversal as:
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */

    public int level = 0;
    HashMap<Integer , List<Integer>> map = new HashMap<>();
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root , 0);
        System.out.println(map.size());
        List<List<Integer>> ret = new ArrayList<>();
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            ret.add(map.get(key));
        }
        return ret;
    }
    */
    /**
     *  BFS 식으로 구현
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            depth++;
            List<Integer> list = new ArrayList<>();
            // 1. Q 의 사이즈를 구한다.
            int size = queue.size();

            // 2. Q 에 노드를 계속 꺼내서 list 에 담는다.
            // 이런식으로 하면 depth 별로 for 문이 돌아가기 때문에 depth 를 쉽게 알 수 있다.
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 3. Depth 의 for 문이 끝나면 결과 list 에 add
            ret.add(list);
        }
        System.out.println("depth : " + depth);
        return ret;
    }

    public List<List<Integer>> levelOrder(TreeNode root , int level) {
        if(root != null) {
            System.out.println(root.val + " , " + level);
            List<Integer> list = null;
            if(map.containsKey(level)) {
                list = map.get(level);
                list.add(root.val);
            } else {
                list = new ArrayList<>();
                list.add(root.val);
            }
            map.put(level , list);

            levelOrder(root.left , level + 1);
            levelOrder(root.right , level + 1);

        }
        return null;
    }



    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal obj = new BinaryTreeLevelOrderTraversal();
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
        obj.levelOrder(root );

    }
}
