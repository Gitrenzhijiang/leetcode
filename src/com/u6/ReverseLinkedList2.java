package com.u6;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 1;
        ListNode t1 = null, t2 = null;
        
        ListNode node = head;
        ListNode node_back = null;
        List<Integer> data = new ArrayList<>();
        while (node != null){
            if (index == m){
                t1 = node_back;
            }else if (index == n+1){
                t2 = node;
                break;
            }
            if (index >= m && index <= n){
                data.add(node.val);
            }
            index++;
            node_back = node;
            node = node.next;
        }
        ListNode temp = null;
        ListNode temp2 = null;
        while (!data.isEmpty()){
            ListNode temp3 = new ListNode(data.remove(data.size()-1));
            if (temp == null){
                temp = temp2 = temp3;
            }else{
                temp2.next = temp3;
                temp2 = temp2.next;
            }
        }
        if (t1 == null){
            t1 = temp;
        }else{
            t1.next = temp;
        }
        temp2.next = t2;
        return t1 == temp?t1:head;
    }
}
