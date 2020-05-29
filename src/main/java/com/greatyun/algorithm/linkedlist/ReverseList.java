package com.greatyun.algorithm.linkedlist;

import com.greatyun.algorithm.common.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseList {

    /**
     * 206. Reverse Linked List
     * Easy
     *
     * 4024
     *
     * 84
     *
     * Add to List
     *
     * Share
     * Reverse a singly linked list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     *
     */


    public ListNode reverseList(ListNode head) {

        if(head == null) return null;

        Stack<ListNode> stack = new Stack<>();

        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode prev = stack.pop();
        ListNode ret = prev;
        while(!stack.isEmpty()) {
            ListNode pop = stack.pop();
            if(pop != null) {
                prev.next = pop;
                pop.next = null;
                prev = pop;
            } else {
                return prev;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ReverseList obj = new ReverseList();
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode listNode = obj.reverseList(node);
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
