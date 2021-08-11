package algorithms.stacks;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:10 PM
 * Algorithm URL: 
 */

public class Queue {

    private static class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        return head.data;
    }

    public void add(int data) {
        Node node = new Node(data);
        if(tail != null) {
            tail.next = node;
        }
        tail = node;

        if(head == null) {
            head = node;
        }
    }

    public int remove() {
        int data = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return data;
    }
}
