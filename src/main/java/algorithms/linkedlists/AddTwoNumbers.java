package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 2021-08-09
 * Time: 12:52 PM
 * Algorithm URL: https://leetcode.com/problems/add-two-numbers/
 */

public class AddTwoNumbers {

    public Node addTwoNumbers(Node l1, Node l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        Node l3Head = new Node(0);
        Node l3 = l3Head;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int value = (carry + (l1 == null? 0:l1.data) + (l2 == null? 0: l2.data)) % 10;
            carry = (carry + (l1 == null? 0:l1.data) + (l2 == null? 0:l2.data)) / 10;
            Node l3Next = new Node(value);
            l3.next = l3Next;
            l3 = l3.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry > 0) {
            Node carryNode = new Node(carry);
            l3.next = carryNode;
        }
        return l3Head.next;
    }

    @Test
    public void addTwoNumbersTest() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(4);

        LinkedList l2 = new LinkedList();
        l2.append(1);
        l2.append(3);
        l2.append(4);

        addTwoNumbers(l1.head, l2.head);
    }
}
