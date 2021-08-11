package algorithms.linkedlists;


/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 10:53 PM
 * Algorithm URL:
 */


public class DoublyLinkedList {

    private class Node {
        int data;
        Node prev;
        Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;

        while(current.next != null) {
            current = current.next;
        }
        Node newNode = new Node(data);

        current.next = newNode;
        newNode.prev = current;
    }

    public Node reverse() {
        Node prev = null;
        Node current = head;

        while(current != null) {
            Node nextNode = current.next;
            current.next = prev;
            current.prev = nextNode;
            prev = current;
            current = nextNode;
        }

        head = prev;
        return head;
    }
}

class DoublyLinkedListTest {

    public static void main(String[] args) {
        DoublyLinkedList db = new DoublyLinkedList();
        db.append(10);
        db.append(15);
        db.append(20);
        db.append(25);
        db.append(30);

        db.reverse();

        System.out.println("hey!");
    }
}
