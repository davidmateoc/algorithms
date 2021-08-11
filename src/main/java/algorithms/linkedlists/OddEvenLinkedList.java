package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/5/21
 * Time: 1:37 AM
 * Algorithm URL: https://leetcode.com/problems/odd-even-linked-list/
 */

public class OddEvenLinkedList {

    public Node oddEvenList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    @Test
    public void oddEvenListTest() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);

        oddEvenList(l1.head);
    }
}
