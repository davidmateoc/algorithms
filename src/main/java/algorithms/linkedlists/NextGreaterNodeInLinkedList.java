package algorithms.linkedlists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 4:38 PM
 * Algorithm URL: https://leetcode.com/problems/next-greater-node-in-linked-list/
 */

public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodesOptimal(Node head) {
        ArrayList<Integer> nodeValues = new ArrayList();
        Node current = head;
        while(current != null) {
            nodeValues.add(current.data);
            current = current.next;
        }

        int[] result = new int[nodeValues.size()]; // When initialized the array is all zeros
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < nodeValues.size(); i++) {
            while(!stack.isEmpty() && nodeValues.get(stack.peek()) < nodeValues.get(i)){
                result[stack.pop()] = nodeValues.get(i);
            }
            stack.push(i);
        }
        return result;
    }

    //Return is a Linked List
    public Node nextLargerNodes(Node head) {
        if(head.next == null) {
            head.data = 0;
            return head;
        }

        Node aPointer = head;
        Node bPointer = head.next;

        while(aPointer.next != null) {

            while(bPointer != null && bPointer.data <= aPointer.data) {
                bPointer = bPointer.next;
            }

            if(bPointer == null) {
                aPointer.data = 0;
                aPointer = aPointer.next;
                bPointer = aPointer;
            }

            while(aPointer != bPointer) {
                if(aPointer.data == bPointer.data) {
                    aPointer.data = 0;
                } else {
                    aPointer.data = bPointer.data;
                }
                aPointer = aPointer.next;
                bPointer = aPointer;
            }

            bPointer = bPointer.next;
        }
        aPointer.data = 0;
        return head;
    }

    //Return is an array
    public int[] nextLargerNodesReturningArray(Node head) {
        if(head.next == null) {
            return new int[]{0};
        }

        Node aPointer = head;
        Node bPointer = head.next;

        while(aPointer.next != null) {

            while(bPointer != null && bPointer.data <= aPointer.data) {
                bPointer = bPointer.next;
            }

            if(bPointer == null) {
                aPointer.data = 0;
                aPointer = aPointer.next;
                bPointer = aPointer;
            }

            while(aPointer != bPointer) {
                if(aPointer.data == bPointer.data) {
                    aPointer.data = 0;
                } else {
                    aPointer.data = bPointer.data;
                }
                aPointer = aPointer.next;
                bPointer = aPointer;
            }

            bPointer = bPointer.next;
        }
        aPointer.data = 0;

        List<Integer> array = new ArrayList();
        while(head != null) {
            array.add(head.data);
            head = head.next;
        }

        int[] resultArray = new int[array.size()];
        for(int i = 0; i < array.size(); i++) {
            resultArray[i] = array.get(i);
        }

        return resultArray;
    }

    public void printArray(int[] array) {
        for(int i : array) {
            System.out.println(i);
        }
    }

    @Test
    public void nextLargerNodesTestA() {
        LinkedList l1 = new LinkedList();
        l1.append(3);
        l1.append(3);
        nextLargerNodes(l1.head);
    }

    @Test
    public void nextLargerNodesTestB() {
        LinkedList l1 = new LinkedList();
        l1.append(2);
        l1.append(2);
        l1.append(5);
        nextLargerNodes(l1.head);
    }

    @Test
    public void nextLargerNodesTestC() {
        LinkedList l1 = new LinkedList();
        l1.append(2);
        l1.append(7);
        l1.append(4);
        l1.append(3);
        l1.append(5);
        nextLargerNodes(l1.head);
        nextLargerNodesOptimal(l1.head); //Should be [7, 0, 5, 5, 0]
    }

    @Test
    public void nextLargerNodesTestD() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(7);
        l1.append(5);
        l1.append(1);
        l1.append(9);
        l1.append(2);
        l1.append(5);
        l1.append(1);
        nextLargerNodes(l1.head);
    }

    @Test
    public void nextLargerNodesTestE() {
        LinkedList l1 = new LinkedList();
        l1.append(9);
        l1.append(7);
        l1.append(6);
        l1.append(7);
        l1.append(6);
        l1.append(9);
        nextLargerNodes(l1.head);
    }
}
