package com.xzj;

import java.util.Hashtable;
import java.util.Map;

/**
 * Create by xuzhijun.online on 2019/5/26.
 */
public class LRUCache2 {


    private int count;
    private int capacity;
    private Map<Integer, DLinkedNode> cache;
    DLinkedNode head, tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new Hashtable<>(capacity);

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.after = tail;
        head.pre = null;
        tail.after = null;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            this.moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            count++;
            if(count > capacity){
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
            }

            node = new DLinkedNode();
            node.key = key;
            node.value = value;

            this.cache.put(key, node);
            this.addNode(node);
        } else {
            node.value = value;
            this.moveToHead(node);
        }

    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.after = head.after;
        node.pre = head;

        head.after.pre = node;
        head.after = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode after = node.after;

        pre.after = after;
        after.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }


    public static void main(String[] args) {

        LRUCache2 cache = new LRUCache2(2 /* 缓存容量 */);

        System.out.println(cache.get(1));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }

}

class DLinkedNode {
    Integer key;
    Integer value;
    DLinkedNode pre;
    DLinkedNode after;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
