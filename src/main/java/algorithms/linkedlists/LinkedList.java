package algorithms.linkedlists;

import org.junit.Test;

/**
 * Created by davidmateo on 2021-07-03
 * Algorithm URL:
 */

public class LinkedList {
    public Node head;

    public void append(int value) {
        if(head == null) {
            head = new Node(value);
            return;
        }

        Node current = head;

        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    public Node appendNode(Node node) {
        if(head == null) {
            return node;
        }
        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return head;
    }

    public void insertAtPosition(int position, int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }

        if(position == 0) {
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }

        Node current = head;
        int currentPos = 0;

        while(current.next != null) {
            if(currentPos == position - 1) {
                Node node = new Node(data);
                node.next = current.next.next;
                current.next = node;
            }
            current = current.next;
            currentPos++;
        }

        // In case we arrive at the end of the list we add it at the end
        current.next = new Node(data);
    }

    public void prepend(int value) {
        Node newHead = new Node(value);
        newHead.next = head;
        head = newHead;
    }

    public void print() {
        if(head == null) {
            System.out.println("Empty linked list");
            return;
        }

        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node getNodeWithValue(int data) {
        Node current = head;

        while(current.next != null) {
            if(current.data == data) {
                return current;
            }
            current = current.next;
        }

        // If not found until the last node, if the node data is the same return the node, if not just return null
        return current.data == data ? current : null;
    }

    public void deleteNodeWithValue(int data) {
        if(head == null) {
            return;
        }

        if(head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;

        while(current.next != null) {
            if(current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public Node deleteNodeByIndex(int position) {
        if(position == 0) {
            return head.next;
        }

        Node current = head;
        int pos = 0;

        while(current.next != null) {
            if(pos == position - 1) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
            pos++;
        }
        return head;
    }

    public void cloneTo(LinkedList l2) {
        if(head == null) {
            return;
        }

        while(head != null) {
            l2.append(head.data);
            head = head.next;
        }
    }

    public Node reverse() {
        if(head == null) {
            return null;
        }

        Node current = head;
        Node prev = null;

        while(current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
        return head;
    }

    @Test
    public void cloneToTest() {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append(11);
        myLinkedList.append(12);
        myLinkedList.append(8);
        myLinkedList.append(18);
        myLinkedList.append(16);
        myLinkedList.append(5);
        myLinkedList.append(18);
        myLinkedList.append(0);

        LinkedList myCopiedLinkedList = new LinkedList();
        myLinkedList.cloneTo(myCopiedLinkedList);
    }
}
