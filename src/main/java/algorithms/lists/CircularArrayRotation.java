package algorithms.lists;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 7/16/21
 * Time: 6:45 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/circular-array-rotation/problem
 */

public class CircularArrayRotation {

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {

        HashMap<Integer, Integer> myMap = new HashMap<>();

        for(int i = 0; i < a.size(); i++) {
            myMap.put((i + k)%a.size(), a.get(i));
        }
        List<Integer> resultOfQueries = new ArrayList();
        for(int query : queries) {
            resultOfQueries.add(myMap.get(query));
        }
        return resultOfQueries;
    }

    @Test
    public void CircularArrayRotationTest() {
        List<Integer> a = List.of(1, 2, 3);
        List<Integer> queries = List.of(0, 1, 2);
        Assert.assertThat(circularArrayRotation(a, 2, queries), Is.is(IsEqual.equalTo(List.of(2, 3, 1))));

    }
}

