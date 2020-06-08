package com.greatyun.algorithm.LeetCode.june;

import com.greatyun.algorithm.common.ListNode;

public class DeleteNode {

    public void deleteNode(ListNode node) {

        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;


        ListNode temp = head;
        ListNode prev = head;
        while(temp != null) {
            if(temp.val == node.val) {
                prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            System.out.print(" " + temp.val);
            temp = temp.next;
        }


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        DeleteNode obj = new DeleteNode();


        obj.deleteNode(node1);
    }

}
