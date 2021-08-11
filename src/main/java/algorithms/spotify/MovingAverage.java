package algorithms.spotify;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Create by davidmateo
 * Date: 7/17/21
 * Time: 3:24 PM
 * Algorithm URL: https://leetcode.com/problems/moving-average-from-data-stream
 */

class MovingAverage {
    int size;
    List<Integer> myList = new ArrayList<>();

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        int windowSum = 0;
        myList.add(val);

        for(int i = Math.max(0, myList.size() - size); i < myList.size(); i++) {
            windowSum += myList.get(i);
        }
        return (double)windowSum / Math.min(myList.size(), size);
    }
}

class MovingAverageConstant {
    int size;
    int numberOfElements = 0;
    int windowTotal = 0;
    Queue queue = new ArrayDeque();

    public MovingAverageConstant(int size) {
        this.size = size;
    }

    public double next(int val) {
        numberOfElements++;
        queue.add(val);

        int tail;
        if(size >= numberOfElements) {
            tail = 0;
        } else {
            tail = (int)queue.poll();
        }
        windowTotal = windowTotal - tail + val;
        return (double)windowTotal/Math.min(numberOfElements, size);
    }
}

class MovingAverageTest {

    public static void main(String[] args) {
        MovingAverage window = new MovingAverage(3);
        System.out.println(window.next(1));
        System.out.println(window.next(10));
        System.out.println(window.next(3));
        System.out.println(window.next(5));

        MovingAverageConstant window2 = new MovingAverageConstant(3);
        System.out.println(window2.next(1));
        System.out.println(window2.next(10));
        System.out.println(window2.next(3));
        System.out.println(window2.next(5));
    }
}

