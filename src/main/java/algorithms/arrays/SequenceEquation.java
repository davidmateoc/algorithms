package algorithms.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Create by davidmateo
 * Date: 7/17/21
 * Time: 12:00 AM
 * Algorithm URL: https://www.hackerrank.com/challenges/permutation-equation/problem
 */

public class SequenceEquation {

    public static List<Integer> permutationEquation(List<Integer> p) {
        List<Integer> perm = new ArrayList<>();
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for(int i = 0; i < p.size(); i++) {
            myMap.put(p.get(i), i + 1);
        }

        for(int i = 1; i <= p.size(); i++) {
            perm.add(myMap.get(myMap.get(i)));
        }
        return perm;
    }

    @Test
    public void SequenceEquationTest() {
        // p = [5, 2, 1, 3, 4];
        permutationEquation(List.of(5, 2, 1, 3, 4));
    }
}

