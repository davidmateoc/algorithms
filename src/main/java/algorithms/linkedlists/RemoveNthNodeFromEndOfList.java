package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/5/21
 * Time: 2:08 AM
 * Algorithm URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNthNodeFromEndOfList {

//    public Node removeNthFromEnd(Node head, int n) {
//        int numberOfNodes = 0;
//        Node current = head;
//        while(current != null) {
//            current = current.next;
//            numberOfNodes++;
//        }
//
//        if(numberOfNodes - n == 0) {
//            return head.next;
//        }
//
//        int i = 1;
//        current = head;
//
//        while(i < numberOfNodes - n) {
//            current = current.next;
//            i++;
//        }
//
//        if(current.next != null) {
//            current.next = current.next.next;
//        }
//
//        return head;
//    }

    public Node removeNthFromEndOptimal(Node head, int n) {
        //This is created to keep the reference to the head
        Node referenceHead = new Node(0);
        referenceHead.next = head;

        //We create two pointers to go through the linked list and keep the same distance between them
        Node slow = referenceHead;
        Node fast = referenceHead;

        //We want to end up one position before the one we want to remove, for that reason we have "n+1"
        //in order to end with one pointer at n+1 position, we need to start one of the pointers n+1 earlier
        //and the other pointer starts at the initial position. If we keep the distance between the pointers advancing
        //with them at the same time, at the point the advanced pointer reaches the end, the other pointer will be at the
        //position we want.
        for(int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return referenceHead.next;
    }

//    @Test
//    public void removeNthFromEndTest() {
//        LinkedList l1 = new LinkedList();
//        l1.append(1);
//        l1.append(2);
//        l1.append(3);
//        l1.append(4);
//        l1.append(5);
//
//        removeNthFromEnd(l1.head, 1);
//    }

    @Test
    public void removeNthFromEndOptimalTest() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        l1.append(5);
        l1.append(6);

        removeNthFromEndOptimal(l1.head, 2);
    }
}
