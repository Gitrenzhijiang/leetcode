package com.u10;
/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @author REN
 * 如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aStart = headA;
        while (headB != null) {
            headA = aStart;
            while (headA != null) {
             // 让headA一直走，看能否走到headb
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
            }
            headB = headB.next;
        }
        return null;
    }
}
