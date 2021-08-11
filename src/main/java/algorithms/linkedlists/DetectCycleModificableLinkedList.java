package algorithms.linkedlists;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 1:35 AM
 * Algorithm URL: https://leetcode.com/problems/linked-list-cycle/
 */

public class DetectCycleModificableLinkedList {

    private class Node {
        int data;
        boolean visited = false;
        Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void append (int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;

        while(current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }


    public boolean hasCycle() {

        if(head == null) {
            return false;
        }

        Node current = head;

        while(current.next != null) {
            if(current.visited) {
                return true;
            } else {
                current.visited = true;
                current = current.next;
            }
        }
        return false;
    }


}
