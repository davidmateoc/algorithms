package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 3:54 PM
 * Algorithm URL: https://leetcode.com/problems/middle-of-the-linked-list/
 */

public class MiddleOfTheLinkedList {

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    @Test
    public void middleNodeTest() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        l1.append(5);

        middleNode(l1.head);
    }
}
