package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 3:02 AM
 * Algorithm URL: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class RemoveDuplicatesFromSortedListII {

    public Node removeDuplicatesFromSortedListII(Node head) {
        Node dummy = new Node(0, head);
        Node prev = dummy;

        while(head != null) {
            if(head.next != null && head.data == head.next.data) {
                while(head.next != null && head.data == head.next.data) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    @Test
    public void RemoveDuplicatesFromSortedListIITest() {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append(1);
        myLinkedList.append(1);
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.append(5);

        System.out.println("Modified Linked list:");
        removeDuplicatesFromSortedListII(myLinkedList.head);
    }
}

