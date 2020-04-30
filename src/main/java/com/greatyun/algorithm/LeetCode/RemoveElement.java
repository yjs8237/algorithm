package com.greatyun.algorithm.LeetCode;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
            } else {
                result++;
            }
        }
        Arrays.sort(nums);
        return result;
    }


    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    Integer prev = Integer.MAX_VALUE;
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prevNode = null;
        ListNode target = head;
        while(target != null) {
            if(prev == target.val ) {
                if(target.next == null) {
                    prevNode.next = null;
                    target = null;
                } else {
                    prev = prevNode.val;
                    prevNode.next = target.next;
                    target = target.next;
                }
            } else {
                prev = target.val;
                prevNode = target;
                target = target.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();
        int [] arr = {0,0,0,1,2,3};
        int val = 0;
//        System.out.println(obj.removeElement(arr , val));
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        node.next = node1;
        node1.next = node2;

        ListNode listNode = obj.deleteDuplicates(node);

        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }


}
