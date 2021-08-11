package algorithms.spotify;

import algorithms.linkedlists.Node;
import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/7/21
 * Time: 1:30 AM
 * Algorithm URL: https://leetcode.com/problems/reverse-linked-list/
 */

public class ReverseLinkedList {

    public Node reverseLinkedList(Node head) {

        Node prev = null;
        while(head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    @Test
    public void ReverseLinkedListTest() {

    }
}

