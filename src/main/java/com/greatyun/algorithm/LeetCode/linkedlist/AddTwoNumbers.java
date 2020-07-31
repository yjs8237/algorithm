package com.greatyun.algorithm.LeetCode.linkedlist;

import com.greatyun.algorithm.common.ListNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Queue<ListNode> queue = new LinkedList<>();
        while(true) {
            if(l1 == null && l2 == null) break;
            if(l1 != null) stack1.push(l1.val);
            if(l2 != null) stack2.push(l2.val);

            if(l1.next != null) {
                l1 = l1.next;
            } else {
                l1 = null;
            }
            if(l2.next != null) {
                l2 = l2.next;
            } else {
                l2 = null;
            }
        }

        boolean isUpstream = false;
        ListNode ret = new ListNode();
        ListNode prevList = null;

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            Integer pop1 = stack1.isEmpty() ? 0 : stack1.pop();
            Integer pop2 = stack2.isEmpty() ? 0 : stack2.pop();
            int val = isUpstream == true ? 1 : 0;
            if(pop1 + pop2 >= 10) {
                isUpstream = true;
                val += (pop1 + pop2) % 10;
            } else {
                isUpstream = false;
                val += pop1 + pop2;
            }

            ret = new ListNode();
            ret.val = val;
            if(prevList != null) {
                prevList.next = ret;
            }
            prevList = ret;
            queue.offer(ret);
        }
        if(isUpstream) {
            ListNode tempNode = new ListNode();
            tempNode.val = 1;
            prevList.next = tempNode;
            queue.offer(tempNode);
        }
        /*
        ret = queue.poll();
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
         */

        return queue.poll();
    }

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(3);

        ListNode node1_1 = new ListNode(0);
//        ListNode node2_2 = new ListNode(6);
//        ListNode node3_3 = new ListNode(4);

        node1.next = node2;
//        node2.next = node3;

//        node1_1.next = node2_2;
//        node2_2.next = node3_3;
        obj.addTwoNumbers(node1 , node1_1);
    }
}
