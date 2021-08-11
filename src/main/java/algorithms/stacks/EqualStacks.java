package algorithms.stacks;

import java.util.List;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:04 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/equal-stacks/problem
 */

public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        MyStack s1 = new MyStack();
        MyStack s2 = new MyStack();
        MyStack s3 = new MyStack();

        int s1Total = 0;
        int s2Total = 0;
        int s3Total = 0;

        //Reverse push of Lists into Stacks
        for(int i = h1.size() - 1; i >= 0; i--) {
            s1.push(h1.get(i));
            s1Total += h1.get(i);
        }
        for(int i = h2.size() - 1; i >= 0; i--) {
            s2.push(h2.get(i));
            s2Total += h2.get(i);
        }
        for(int i = h3.size() - 1; i >= 0; i--) {
            s3.push(h3.get(i));
            s3Total += h3.get(i);
        }

        boolean equalHeight = false;
        while(!equalHeight) {
            equalHeight = true;
            if(s1Total > s2Total || s1Total > s3Total) {
                s1Total -= s1.pop();
                equalHeight = false;
            } else if (s2Total > s1Total || s2Total > s3Total) {
                s2Total -= s2.pop();
                equalHeight = false;
            } else if (s3Total > s1Total || s3Total > s2Total) {
                s3Total -= s3.pop();
                equalHeight = false;
            }
        }

        return s1Total;
    }

    public static void main(String[] args) {
        List<Integer> h1 = List.of(3, 2, 1, 1, 1);
        List<Integer> h2 = List.of(4, 3, 2);
        List<Integer> h3 = List.of(1, 1, 4, 1);

        System.out.println(equalStacks(h1, h2, h3));
    }

}

class MyStack {

    private class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int peek() {
        return top.data;
    }

    public int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }
}