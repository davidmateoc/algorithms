package algorithms.arrays;

import org.junit.Test;

import java.util.TreeMap;

import static junit.framework.TestCase.assertTrue;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:30 PM
 * Algorithm URL: https://leetcode.com/problems/hand-of-straights/
 */

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {

        //We just add every card in our hand to a TreeMap because its a data structure that keeps sorted based on the key
        TreeMap<Integer, Integer> myTreeMap = new TreeMap();
        for(int card : hand) {
            if(myTreeMap.containsKey(card)) {
                myTreeMap.put(card, myTreeMap.get(card) + 1);
            } else {
                myTreeMap.put(card, 1);
            }
        }

        while(myTreeMap.size() > 0) {
            //We get the first element in the TreeMap
            int firstCard = myTreeMap.firstKey();

            //We go from the first element up to W elements. Since we are using the cards as keys, and they need
            //them to be consecutive we can iterate through them. If the size of the TreeMap is 1 we will end up inside
            //the for loop, but the next indexes of firstCard won't be found, resulting in a return false
            for(int i = firstCard; i < firstCard + W; i++) {
                if(!myTreeMap.containsKey(i)) {
                    return false;
                } else {
                    //If TreeMap contains the key, and its value is 1, we remove it because its used to create a group
                    //but if the value is not one, we just recrease its value by 1
                    if(myTreeMap.get(i) == 1) {
                        myTreeMap.remove(i);
                    } else {
                        myTreeMap.put(i, myTreeMap.get(i) - 1);
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void isNStraightHandTest() {
        assertTrue(isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 3));
    }
}
