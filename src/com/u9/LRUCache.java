package com.u9;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /**
     * ["LRUCache","put","put","put","put","get","get"]
[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
     * @param args
     */
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        Node n = null;
        cache.put(2, 1);
        n = cache.head.next;
        while (n != null) {
            System.out.println(n.key);
            n = n.next;
        }
        System.out.println("===");
        cache.put(1, 2);
        n = cache.head.next;
        while (n != null) {
            System.out.println(n.key);
            n = n.next;
        }
        System.out.println("===");
        cache.put(2, 3);
        n = cache.head.next;
        while (n != null) {
            System.out.println(n.key);
            n = n.next;
        }
        System.out.println("===");
        cache.put(4, 1);
        n = cache.head.next;
        while (n != null) {
            System.out.println(n.key);
            n = n.next;
        }
        System.out.println("===");
        cache.get(1);
        n = cache.head.next;
        while (n != null) {
            System.out.println(n.key);
            n = n.next;
        }
        System.out.println("===");
        cache.get(2);
        n = cache.head.next;
        while (n != null) {
            System.out.println(n.key);
            n = n.next;
        }
        System.out.println("===");
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    // 如果缓存中存在, 则返回(value>=0); 如果不存在, 返回-1
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            toEnd(node);
            return node.value;
        }else {
            return -1;
        }
    }
    // 如果缓存中没有, 直接插入, 如果有, 删除原先的, 再插入
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.remove(key);
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            if (next == null) {
                if (pre == head){
                    head.pre = null;
                }else{
                    head.pre = pre;
                }
            }else {
                next.pre = pre;
            }
            used--;
        }
        // 创建新结点
        Node newNode = new Node();
        newNode.setKey(key);
        newNode.setValue(value);
        // 是否即将超出容量
        if (used >= capacity) {
            elimate();
        }
        if (head.pre != null) {
            head.pre.next = newNode;
            newNode.pre = head.pre;
            head.pre = newNode;
        }else {
            head.next = newNode;
            newNode.pre = head;
            head.pre = newNode;
        }
        used++;
        map.put(newNode.key, newNode);
    }
    
    private void toEnd(Node node) {
     // 取到尾部
        if (node.next != null) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
            head.pre.next = node;
            node.pre = head.pre;
            node.next = null;
            head.pre = node;
        }
    }
    private void elimate() {
     // 即将超出
        if (head.next != null) {
            Node remove = head.next;
            Node t = head.next.next;
            head.next = t;
            if (t != null) {
                t.pre = head;    
            }
            if (head.next == null) {
                head.pre = null;
            }
            used--;
            map.remove(remove.key);
        }
    }
    private Map<Integer, Node> map = new HashMap<>();
    /**
     * 头结点
     * 头结点的pre指向null 或者是当前链表的最后一个结点
     */
    private Node head = new Node();
    /**
     * 最大长度
     */
    private int capacity = 16;
    /**
     * 已经使用的长度
     */
    private int used = 0;
    private static class Node{
        int key;
        int value;
        Node next;
        Node pre;
        
        public void setKey(int key) {
            this.key = key;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }
}