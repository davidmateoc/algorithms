package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 12:37 AM
 * Algorithm URL: https://leetcode.com/problems/intersection-of-two-linked-lists/
 */

public class IntersectionOfTwoLinkedLists {


    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }

        Node aPointer = headA;
        Node bPointer = headB;

        while(aPointer != bPointer) {
            if(aPointer == null) {
                aPointer = headB;
            } else {
                aPointer = aPointer.next;
            }

            if(bPointer == null) {
                bPointer = headA;
            } else {
                bPointer = bPointer.next;
            }
        }
        return aPointer;
    }

    @Test
    public void getIntersectionNodeTest() {
        LinkedList l1 = new LinkedList();
        l1.append(5);
        l1.append(1);
        l1.append(2);
        l1.append(4);

        LinkedList l2 = new LinkedList();
        l2.append(7);
        l2.append(1);
        l2.append(2);
        l2.append(4);

        getIntersectionNode(l1.head, l2.head);
    }

}
