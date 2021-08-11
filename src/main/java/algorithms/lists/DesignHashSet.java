package algorithms.lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 8/7/21
 * Time: 6:19 PM
 * Algorithm URL: https://leetcode.com/problems/design-hashset/
 */

public class DesignHashSet {
/**    Option 1: Using a List */
//    List<Integer> myList;
//    /** Initialize your data structure here. */
//    public DesignHashSet() {
//        myList = new ArrayList<>();
//    }
//
//    public void add(int key) {
//        if(!myList.contains(key)) {
//            myList.add(key);
//        }
//    }
//
//    public void remove(int key) {
//        for(int i = 0; i < myList.size(); i++) {
//            if(myList.get(i) == key) {
//                myList.remove(i);
//            }
//        }
//    }
//
//    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//        return myList.contains(key);
//    }
/**    Option 2: Using a boolean array */
//    boolean[] array;
//
//    /** Initialize your data structure here. */
//    public DesignHashSet() {
//        array = new boolean[1000001];
//    }
//
//    public void add(int key) {
//        array[key] = true;
//    }
//
//    public void remove(int key) {
//        array[key] = false;
//    }
//
//    /** Returns true if this set contains the specified element */
//    public boolean contains(int key) {
//        return array[key];
//    }

    @Test
    public void DesignHashSetTest() {
    int[] array = new int[1000];
        Arrays.fill(array, 10000);
    }
}

