package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/5/21
 * Time: 1:53 AM
 * Algorithm URL: https://leetcode.com/problems/partition-list/
 */

public class PartitionList {

    public Node partition(Node head, int x) {
        if(head == null) {
            return head;
        }

        Node beforeHead = new Node(0);
        Node before = beforeHead;
        Node afterHead = new Node(0);
        Node after = afterHead;

        while(head != null) {
            if(head.data < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }

    @Test
    public void partitionTest() {

    }

}
