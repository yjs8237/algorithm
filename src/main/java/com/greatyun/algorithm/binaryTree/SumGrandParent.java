package com.greatyun.algorithm.binaryTree;

import com.greatyun.algorithm.LeetCode.binarySearch.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumGrandParent {

    /**
     * 해당 노드 부모-부모 (할아버지 노드) 가 짝수일 경우에만 해당 노드의 합을 더해서 리턴하는 함수를 작성하시오.
     *
     *
     * 나 자신을 list 에 넣고 노드를 끝까지 다 탐색한다.
     * list 의 size 가 3 이상이면 할아버지 노드의 값을 가져와서 짝수인지 구분하여 로직 실행
     *
     * 할아버지 노드 탐색 조건은 left , right 탐색이 끝난 다음에 진행해야 한다.
     */

    List<Integer> list = new ArrayList<>(3);

    int ret = 0;
    LinkedList<TreeNode> linkedList = new LinkedList<>();
    public int sumEvenGrandparent(TreeNode root) {
        if(root != null) {
            linkedList.add(root);
            sumEvenGrandparent(root.left);
            sumEvenGrandparent(root.right);
            if(linkedList.size() >= 3) {
                TreeNode treeNode = linkedList.get(linkedList.size() - 3);
                if(treeNode.val % 2 == 0) {
                    ret += root.val;
                }
                System.out.println("my : " + root.val + " , parent : " + treeNode.val);
            } else {

            }
            linkedList.remove(root);
        }
        return ret;
    }

    public static void main(String[] args) {
        SumGrandParent obj = new SumGrandParent();
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
        System.out.println(obj.sumEvenGrandparent(root));

    }
}
