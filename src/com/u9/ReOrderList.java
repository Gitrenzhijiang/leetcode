package com.u9;

import java.util.ArrayList;
import java.util.List;

public class ReOrderList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;l2.next = l3; l3.next = l4;
        l4.next = l5;l5.next = l6;l6.next = l7;
        new ReOrderList().reorderListByFastAndSlowPoint(l1);
        
        ListNode t = l1;
        while (t != null) {
            System.out.println(t.val);
            t = t.next;
        }
        
    }
    
    public void reorderListByFastAndSlowPoint(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 找到链表中间的结点
        // 将第二个链表倒置
        // 将第二个链表间隔地插入第一个链表
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 此时slow指向的就是中间节点
        ListNode s = slow;
        ListNode t = slow.next;
        s.next = null;
        while (t != null) {
            ListNode temp = t.next;
            t.next = s;
            s = t;
            t = temp;
        }
        ListNode h = head;
        // s为第二个链表的第一个结点
        while (s != null) {
            if (h == s || h.next == s) {
                break;
            }
            ListNode temp = h.next;
            ListNode temp2 = s.next;
            h.next = s;
            s.next = temp;
            h = temp;
            s = temp2;
        }
    }
    
    
    
    public void reorderList(ListNode head) {
        List<ListNode> buff = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            buff.add(node);
            node = node.next;
        }
        ListNode k = head;
        int s = 1, e = buff.size()-1;
        while (s <= e) {
            if (s == e) {
                k.next = buff.get(s);
                k = k.next;
                k.next = null;
            }else {
                k.next = buff.get(e);
                k = k.next;
                k.next = buff.get(s);
                k = k.next;
                k.next = null;
            }
            s++;
            e--;
        }
    }
}
