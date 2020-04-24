package com.greatyun.algorithm.LeetCode;

import java.util.*;

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    ListNode root;

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) return null;

        LinkedList<Integer> linkedList = new LinkedList<>();
        while (l1 != null) {
            linkedList.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            linkedList.add(l2.val);
            l2 = l2.next;
        }

        Collections.sort(linkedList);

        ListNode root;
        Stack<ListNode> stack = new Stack<>();

        for (int i = 0; i < linkedList.size(); i++) {
            int num = linkedList.get(i);
            if(i == 0) {
                root = new ListNode(num);
                stack.push(root);
            } else {
                ListNode node = new ListNode(num);
                ListNode peek = stack.peek();
                peek.next = node;
                stack.push(node);
            }
        }

        return stack.firstElement();
    }

    public ListNode insertNode(int val) {
        if(root == null){
            root = new ListNode(val);
        } else {

            while(root != null) {
                if(root.val < val) {
                    root = root.next;
                } else {

                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        node4.next = node5;
        node5.next = node6;
        mergeTwoLists(node1 , node4);
    }
}
