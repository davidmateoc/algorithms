package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 4:56 PM
 * Algorithm URL: https://leetcode.com/problems/sort-list/
 */

public class SortList {

    public Node sortList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;

        Node leftSide = sortList(head);
        Node rightSide = sortList(slow);

        return merge(leftSide, rightSide);
    }

    public Node merge(Node l1, Node l2) {

        Node sortedTemp = new Node(0);
        Node current = sortedTemp;

        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null) {
            current.next = l1;
        }

        if(l2 != null) {
            current.next = l2;
        }

        return sortedTemp.next;
    }

    @Test
    public void sortListTest() {

    }

}
