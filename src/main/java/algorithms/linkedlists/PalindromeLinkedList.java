package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 7:28 PM
 * Algorithm URL: https://leetcode.com/problems/palindrome-linked-list/
 */

public class PalindromeLinkedList {

    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reversed(slow);
        fast = head;

        while(slow != null) {
            if(slow.data != fast.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public Node reversed(Node head){
         Node prev = null;
         while(head != null) {
             Node temp = head.next;
             head.next = prev;
             prev = head;
             head = temp;
         }
         return prev;
    }

    @Test
    public void isPalindromeTest() {
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(1);
        l1.append(2);
        l1.append(2);
        l1.append(1);

        System.out.println(isPalindrome(l1.head));
    }
}
