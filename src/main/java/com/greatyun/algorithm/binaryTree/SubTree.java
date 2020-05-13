package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

public class SubTree {
    /**
     * 두 개의 트리가 주어졌을때 하나의 트리가 나머지 하나의 트리의 sub 트리인지 확인하는 알고리즘을 작성하시오.
     */


    public boolean isSubTree(TreeNode t1 , TreeNode t2) {
        if(t2 == null) return true; // 비어있는 트리는 언제나 하위 트리가 된다
        return subTree(t1 , t2);
    }

    public boolean subTree(TreeNode t1 , TreeNode t2) {
        if(t1 == null) {
            return false;
        } else if(t1.val == t2.val && matchTree(t1 , t2)) {
            // 찾으려는 t1 t2 노드의 값이 존재하면 그때부터 하위트리가 동일한지 체크하자
            return true;
        }
        // 값이 동일하지 않으면 재귀 호출로 값이 동일한 노드가 나타날때까지 왼쪽 , 오른쪽 호출
        return subTree(t1.left , t2) || subTree(t1.right , t2);
    }

    private boolean matchTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        } else if(t1 == null || t2 == null) {   // 두 노드 중 하나라도 null 이면 동일한 트리가 아니다.
            return false;
        } else if(t1.val != t2.val) {       // 노드 탐색 중 노드의 값이 다르면 동일한 트리가 아니다.
            return false;
        } else {
            // 왼쪽 오른쪽 같이 찾으면서 재귀 호출
            return matchTree(t1.left , t2.left) && matchTree(t1.right , t2.right);
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


    }
}
