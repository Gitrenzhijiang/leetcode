package com.u9;

public class InsertSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ret = head;
        ListNode node = head.next;
        ret.next = null;
        while (node != null){
            ListNode nnext = node.next;
            node.next = null;
            // 将node放入 ret为首的链表中
            ListNode t_back = null;
            ListNode temp = ret;
            while (temp != null && node.val > temp.val){
                t_back = temp;
                temp = temp.next;
            }
            if (t_back != null && temp != null){
                t_back.next = node;
                node.next = temp;
            }else if (t_back == null && temp != null){
                node.next = ret;
                ret = node;
            }else{
                t_back.next = node;
            }
            node = nnext;
        }
        return ret;
    }
}
