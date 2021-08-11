package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/5/21
 * Time: 2:28 AM
 * Algorithm URL: https://leetcode.com/problems/reorder-list/
 */

public class ReorderList {
    public void reorderList(Node head) {
        if(head == null || head.next == null) {
            return;
        }

        Node l1 = head; //head of the first half
        Node slow = head; //head of the second half
        Node fast = head; //tail of the second half
        Node prev = null; //tail of the first half

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        Node l2 = reverse(slow);

        merge(l1, l2);

    }

    public Node reverse(Node head) {
        Node prev = null;

        while(head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public void merge(Node l1, Node l2) {
        while(l1 != null) {
            Node l1Next = l1.next;
            Node l2Next = l2.next;

            l1.next = l2;

            if(l1Next == null) {
                break;
            }

            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }

    @Test
    public void reorderListTest() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        l1.append(5);


        reorderList(l1.head);
    }
}
