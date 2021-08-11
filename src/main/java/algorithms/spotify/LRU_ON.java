package algorithms.spotify;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by davidmateo
 * Date: 7/18/21
 * Time: 8:42 PM
 * Algorithm URL: https://leetcode.com/problems/lru-cache/
 */

public class LRU_ON {

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> mapNode;
    int cacheCapacity;

    public LRU_ON(int capacity) {
        cacheCapacity = capacity;
        mapNode = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        int result = -1;
        Node node = mapNode.get(key);
        if(node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = mapNode.get(key);
        if(node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if(mapNode.size() == cacheCapacity) {
                mapNode.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            mapNode.put(key, newNode);
            add(newNode);
        }
    }

    public void add(Node node) {
        Node headNext = node.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    @Test
    public void LRU_ONTest() {

    }
}

