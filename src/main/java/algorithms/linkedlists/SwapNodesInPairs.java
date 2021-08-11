package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 12:44 PM
 * Algorithm URL: https://leetcode.com/problems/swap-nodes-in-pairs/
 */

public class SwapNodesInPairs {
    public Node swapPairs(Node head) {
        Node temp = new Node(0);
        temp.next = head;

        Node current = temp;
        while(current.next != null && current.next.next != null) {
            Node firstNode = current.next;
            Node secondNode = current.next.next;

            firstNode.next = secondNode.next;
            current.next = secondNode;
            secondNode.next = firstNode;
            current = firstNode;
        }
        return temp.next;
    }

    @Test
    public void SwapNodesInPairsTest() {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);

        System.out.println("Original Linked list:");
        myLinkedList.print();

        System.out.println("Modified Linked list:");
        swapPairs(myLinkedList.head);
        myLinkedList.print();
    }
}
