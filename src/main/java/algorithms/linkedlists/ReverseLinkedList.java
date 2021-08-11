package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/3/21
 * Time: 10:56 PM
 * Algorithm URL: https://leetcode.com/problems/reverse-linked-list/
 */

public class ReverseLinkedList {

    public Node reverseList(Node head) {
        Node previousNode = null;

        while(head != null) {
            Node nextNode = head.next;
            head.next = previousNode;
            previousNode = head;
            head = nextNode;
        }
        return previousNode;
    }

    @Test
    public void reverseListTest() {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        reverseList(myLinkedList.head);
    }
}
