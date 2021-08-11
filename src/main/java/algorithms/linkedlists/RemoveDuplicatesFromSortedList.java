package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 1:48 AM
 * Algorithm URL: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

public class RemoveDuplicatesFromSortedList {

    public Node deleteDuplicates(Node head) {
        if(head == null) {
            return null;
        }

        Node current = head;

        while(current.next != null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    @Test
    public void RemoveDuplicatesFromSortedListTest() {

    }
}

