package algorithms.linkedlists;

import org.junit.Test;

/**
 * Create by davidmateo
 * Date: 8/8/21
 * Time: 10:54 PM
 * Algorithm URL:
 */

public class CountNodes {

    public static int countNodes(Node head) {
        int counter = 1;
        while (head.next != null) {
            counter++;
            head=head.next;
        }
        return counter;
    }

    @Test
    public void CountNodesTest() {

    }
}

