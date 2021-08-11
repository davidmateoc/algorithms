package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 1:35 AM
 * Algorithm URL: https://leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle {

    public boolean hasCycle(Node head) {
        if(head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            if(slow == fast) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    @Test
    public void hasCycleTest() {

    }
}
