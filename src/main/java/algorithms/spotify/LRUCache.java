package algorithms.spotify;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Create by davidmateo
 * Date: 7/18/21
 * Time: 6:29 PM
 * Algorithm URL: https://leetcode.com/problems/lru-cache/
 */

public class LRUCache {
    int capacity;
    HashMap<Integer, Integer> myMap;
    Deque<Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        myMap = new HashMap(capacity);
        cache = new LinkedList();
    }

    public int get(int key) {
        if(myMap.containsKey(key)) {
            cache.remove(key);
            cache.push(key);
            return myMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.contains(key)) {
            cache.remove(key);
        } else {
            if(cache.size() == capacity) {
                int last = cache.removeLast();
                myMap.remove(last);
            }
        }
        cache.push(key);
        myMap.put(key, value);
    }

    public static void main(String[] args) {
        //["LRUCache","get","put","get","put","put","get","get"]
        //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);
    }
}

