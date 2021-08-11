package algorithms.linkedlists;


/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:53 PM
 * Algorithm URL: //https://www.youtube.com/watch?v=MFOAbpfrJ8g&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=4
 */

public class CircularLinkedList {

    private class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public void add(int data) {
        Node node = new Node(data);
        if(head == null) {
            head = node;
            tail = node;
            node.next = head;
        } else {
          tail.next = node;
          tail = node;
          tail.next = head;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList myCircularLinkedList = new CircularLinkedList();
        myCircularLinkedList.add(10);
        myCircularLinkedList.add(11);
        myCircularLinkedList.add(12);
        myCircularLinkedList.add(13);
        System.out.println();
    }
}
