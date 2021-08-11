package algorithms.linkedlists;

import org.junit.Test;

import java.util.HashSet;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 1:56 AM
 * Algorithm URL: https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/
 */

public class RemoveDuplicatesFromAnUnsortedLinkedList {

    public Node deleteDuplicatesFromAnUnsortedLinkedList(Node head) {
        if(head == null) {
            return null;
        }

        HashSet<Integer> mySet = new HashSet<>();
        Node current = head;
        mySet.add(current.data);

        while(current.next != null) {
            if(mySet.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                mySet.add(current.next.data);
                current = current.next;
            }
        }
        return head;
    }

    @Test
    public void RemoveDuplicatesFromAnUnsortedLinkedListTest() {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append(1);
        myLinkedList.append(1);
        myLinkedList.append(5);
        myLinkedList.append(3);
        myLinkedList.append(5);

        System.out.println("Modified Linked list:");
        deleteDuplicatesFromAnUnsortedLinkedList(myLinkedList.head);
        myLinkedList.print();
    }
}

