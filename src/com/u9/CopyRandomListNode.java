package com.u9;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomListNode {

    public static void main(String[] args) {
        
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode t_head = head;
        RandomListNode copyHead = cloneNode(t_head);
        RandomListNode ret = copyHead;
        while (t_head != null) {
            t_head = t_head.next;
            copyHead.next = cloneNode(t_head);
            copyHead = copyHead.next;
        }
        return ret;
    }
    private Map<Integer, RandomListNode> buff = new HashMap<>();
    private RandomListNode cloneNode (RandomListNode node) {
        if (node == null) {
            return null;
        }else if (buff.containsKey(node.label)) {
            return buff.get(node.label);
        }
        RandomListNode ret = new RandomListNode(node.label);
        ret.next = node.next;
        buff.put(ret.label, ret);
        ret.random = cloneNode(node.random);
        return ret;
    }
}
/**
 * 带有随机指针的链表
 * @author renzhijiang
 *
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
};
