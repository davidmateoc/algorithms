package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/3/21
 * Time: 10:56 PM
 * Algorithm URL: https://leetcode.com/problems/reverse-linked-list-ii/
 */

public class ReverseLinkedListII {

    public Node reverseBetween(Node head, int left, int right) {
        if(head == null) {
            return null;
        }

        Node prev = null;
        Node current = head;

        while(left > 1) {
            prev = current;
            current = current.next;
            left--;
            right--;
        }

        Node connection = prev;
        Node tail = current;

        while(right > 0) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            right--;
        }

        if(connection != null) {
            connection.next = prev;
        } else {
            head = prev;
        }
        tail.next = current;

        return head;
    }

    @Test
    public void reverseBetweenTest() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        l1.append(5);

        reverseBetween(l1.head, 2, 4);
    }
}
