package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

public class FindCorrespondingNode {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return searchNode(cloned , 3);
    }

    public TreeNode searchNode(TreeNode root , int targetVal) {
        if(root != null) {
            if(root.val == targetVal){
                return root;
            }

            // 왼쪽 오른쪽 재귀로 일단 다 돌아보고 나서 리턴된 결과 객체의 null 여부를 체크한다.
            // 노드를 찾지 못하면 결국에는 null 이 리턴되게끔 되어 구현되어 있기 때문에
            TreeNode left = searchNode(root.left , targetVal);
            TreeNode right = searchNode(root.right , targetVal);

            if(left != null) return left;
            if(right != null) return right;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        FindCorrespondingNode obj = new FindCorrespondingNode();
        TreeNode targetCopy = obj.getTargetCopy(root, root, node1);
        System.out.println(targetCopy.val);
    }
}
