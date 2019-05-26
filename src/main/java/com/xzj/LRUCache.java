package com.xzj;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Create by xuzhijun.online on 2019/5/26.
 */
public class LRUCache {

    private int cap;
    private Map<Integer, Integer> map = new LinkedHashMap<>();  // 保持插入顺序

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
//            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
//            iterator.next();
//            iterator.remove();

             int firstKey = map.entrySet().iterator().next().getKey();
             map.remove(firstKey);
        }
        map.put(key, value);
    }


    public static void main(String[] args) {

        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        System.out.println(cache.get(1));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));


    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
