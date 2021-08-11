package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 7/4/21
 * Time: 1:05 AM
 * Algorithm URL:
 */

public class DuplicateLinkedList {

    public LinkedList DuplicateLinkedList(LinkedList l1) {

        if(l1.head == null) {
            return null;
        }

        LinkedList l2 = new LinkedList();

        while(l1.head != null) {
            l2.append(l1.head.data);
            l1.head = l1.head.next;
        }
        return l2;
    }

    @Test
    public void DuplicateLinkedListTest() {
        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append(11);
        myLinkedList.append(12);
        myLinkedList.append(8);
        myLinkedList.append(18);
        myLinkedList.append(16);
        myLinkedList.append(5);
        myLinkedList.append(18);
        myLinkedList.append(0);

        DuplicateLinkedList(myLinkedList);

    }
}

