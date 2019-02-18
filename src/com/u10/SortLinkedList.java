package com.u10;

public class SortLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        
        n4.next = n2;
        n2.next = n1;
        n1.next = n3;
        
        ListNode ret = new SortLinkedList().sortList(n4);
        System.out.println("hello world:");
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    public ListNode sortList(ListNode head) {
        ListNode my = new ListNode(0);
        my.next = head;
        sortList(my, null);
        return my.next;
    }
    /**
     * pre -> -1 -> 3 -> ... -> successor(可能为null)
     * 对 中间部分链表进行排序
     * @param pre
     * @param successor
     */
    private void sortList(ListNode pre, ListNode successor) {
        if (pre == null) {
            throw new RuntimeException("前驱结点不能为空");
        }else if (pre.next == null) {
            return;
        }else if (pre.next == successor) {
            return;
        }else if (pre.next.next == successor) {
            return;
        }
        ListNode lastMin = null;// base的前一个元素
        ListNode equalNode = null;// 第一个与base相同的元素
        ListNode base = pre.next;
        ListNode pnode = base;
        ListNode node = base.next;
        while (node != successor) {
            ListNode willgo = node.next;
            if (node.val <= base.val) {
                pnode.next = node.next;
                if (lastMin == null) {
                    // 当前没有一个元素
                    node.next = pre.next;
                    pre.next = node;
                    lastMin = node;
                    if (lastMin.val == base.val) {
                        equalNode = node;
                    }
                }else if (node.val < base.val){
                    node.next = pre.next;
                    pre.next = node;
                }else {
                    // 相等时
                    node.next = base;
                    lastMin.next = node;
                    lastMin = node;
                    if (equalNode == null) {
                        equalNode = node;
                    }
                }
                
            }else {
                pnode = node;
            }
            node = willgo;
        }
        sortList(pre, equalNode != null?equalNode:base);
        sortList(base, successor);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
