package com.u6;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class PartitionList {

    /**
     * (i, j] < x    (j,.. >= x
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode i = new ListNode(-1);
        ListNode j = i;
        i.next = head;
        ListNode temp = head;
        ListNode tback = i;
        while (temp != null) {
            if (temp.val < x) {
                // < x
                if (j.next != temp) {
                    tback.next = tback.next.next;
                    
                    ListNode back = j.next;
                    j.next = temp;
                    temp.next = back;
                    j = temp;
                    temp = tback.next;
                    continue;
                }else {
                    j = temp;
                }
                
            }
            tback = temp;
            temp = temp.next;
        }
        return i.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}