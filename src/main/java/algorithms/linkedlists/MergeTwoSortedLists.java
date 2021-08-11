package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 3:03 PM
 * Algorithm URL: https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class MergeTwoSortedLists {

    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        Node l3;
        if(l1.data < l2.data) {
            l3 = l1;
            l1 = l1.next;
        } else {
            l3 = l2;
            l2 = l2.next;
        }

        Node current = l3;
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

        if(l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }

        return l3;
    }


    @Test
    public void mergeTwoListsTest() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(4);

        LinkedList l2 = new LinkedList();
        l2.append(1);
        l2.append(3);
        l2.append(4);

        mergeTwoLists(l1.head, l2.head);
    }

}
