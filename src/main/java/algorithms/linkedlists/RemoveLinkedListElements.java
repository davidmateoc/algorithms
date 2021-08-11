package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 12:20 PM
 * Algorithm URL: https://leetcode.com/problems/remove-linked-list-elements/
 */


public class RemoveLinkedListElements {

    public Node removeElements(Node head, int val) {
        while(head != null && head.data == val) {
            head = head.next;
        }

        Node current = head;
        while(current.next != null) {
            if(current.next.data == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    @Test
    public void removeElementsTest() {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append(1);
        myLinkedList.append(4);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        System.out.println("Original Linked list:");
        myLinkedList.print();

        removeElements(myLinkedList.head, 4);
        System.out.println("Modified Linked list:");
        myLinkedList.print();
    }
}
