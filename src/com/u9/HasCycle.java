package com.u9;
/*
给定一个链表，判断链表中是否有环。
进阶：
你能否不使用额外空间解决此题？
 */
public class HasCycle {

    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode node = head;
        while (node != null) {
            // 测试当前node是否连接到前面的结点
            if (node.next != null) {
                ListNode t = node.next;
                if (t != null && t == head) {
                    return true;
                }
            }
            ListNode tt = node.next;
            node.next = head;
            node = tt;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
