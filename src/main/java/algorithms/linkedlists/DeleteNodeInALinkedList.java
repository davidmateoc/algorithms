package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 12:32 AM
 * Algorithm URL: https://leetcode.com/problems/delete-node-in-a-linked-list/
 */

public class DeleteNodeInALinkedList {

    public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    @Test
    public void deleteNodeTest() {

    }
}
