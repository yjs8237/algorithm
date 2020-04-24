package com.greatyun.algorithm.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    /**
     * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * Example:
     *
     * LRUCache cache = new LRUCache( 2 /* capacity )
     *
        *cache.put(1,1);
     *cache.put(2,2);
     *cache.get(1);       // returns 1
     *cache.put(3,3);    // evicts key 2
     *cache.get(2);       // returns -1 (not found)
     *cache.put(4,4);    // evicts key 1
     *cache.get(1);       // returns -1 (not found)
     *cache.get(3);       // returns 3
     *cache.get(4);       // returns 4
     *
     */
    class Cache {
        int key;
        int cache;
        public Cache(int key , int cache) {
            this.key = key;
            this.cache = cache;
        }
    }
    LinkedList<Cache> linkedList;
    HashMap<Integer , Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        linkedList = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int result = map.get(key) == null ? -1 : map.get(key);
        if(result != -1) {
            for (Cache cache: linkedList) {
                if(cache.key == key) {
                    cache.cache = cache.cache + 1;
                }
            }
        }
        System.out.println("get -> " + result);
        return result;
    }

    public void put(int key, int value) {
        if(map.size() < capacity) {
            Cache cache = new Cache(key , 0);
            linkedList.add(cache);
            map.put(key , value);
        } else if(map.size() == capacity) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < linkedList.size(); i++) {
                Cache cache = linkedList.get(i);
                if (cache.cache == 0) {
                    Cache remove = linkedList.remove(index);
                    map.remove(remove.key);
                    return;
                }
                if (min > cache.cache) {
                    min = cache.cache;
                    index = i;
                }
            }

            Cache remove = linkedList.remove(index);
            map.remove(remove.key);
        }
    }


    public static void main(String [] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
