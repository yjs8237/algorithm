package com.greatyun.algorithm.LeetCode.Tree;

public class UnivaluedBinaryTree {

    /**
     * 주어진 이진 트리의 데이터가 모두 동일한지 체크 하는 문제
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int rootData;
    private boolean isSame = true;

    public  boolean isUnivalTree(TreeNode root) {
        rootData = root.val;
        checkTree(root);
        return isSame;
    }

    public void checkTree(TreeNode node) {
        if(node != null) {
            /**
             * 이진트리를 순회하면서 root 노드의 데이터와 동일하지 않는 데이터 발견시 flag 값을 false 로 업데이트 하고
             * 재귀 종료
             */
            if(node.val != rootData) {
                isSame = false;
                return;
            }
            checkTree(node.left);
            checkTree(node.right);
        }
    }

    /**
     * 이진트리의 L 과 R 사이의 Value 를 Sum 해서 리턴
     */
    Integer result = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root != null) {
            if(root.val >= L && root.val <= R) {
                result += root.val;
            }
            rangeSumBST(root.left , L , R);
            rangeSumBST(root.right , L , R);
        }
        return result;
    }

    public static void main( String [] agrs) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        UnivaluedBinaryTree obj = new UnivaluedBinaryTree();

//        System.out.println(obj.isUnivalTree(root));
        System.out.println(obj.rangeSumBST(root , 1 ,2));
    }
}
