package algorithms.stacks;

import java.util.Scanner;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:04 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/maximum-element/problem
 */

public class MaximumElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        MyFavStack stack = new MyFavStack();

        while (n > 0) {
            int choice = sc.nextInt();
            if (choice == 1) {
                int val = sc.nextInt();
                max = Math.max(val, max);
                stack.push(val, max);
            } else if (choice == 2) {
                stack.pop();
                max = stack.getCurrentMax();
            } else if (choice == 3) {
                System.out.println(stack.getCurrentMax());;
            }
            n--;
        }
        sc.close();
    }
}

class MyFavStack {
    private class Node {
        private int data;
        private int currentMax;
        private Node next;
        private Node(int data, int currentMax) {
            this.data = data;
            this.currentMax = currentMax;
        }
    }

    private Node top;

    public int push(int data, int currentMax) {
        Node node = new Node(data, currentMax);
        node.next = top;
        top = node;
        return data;
    }

    public int getCurrentMax() {
        if(top != null){
            return top.currentMax;
        }
        return Integer.MIN_VALUE;
    }

    public int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }
}
