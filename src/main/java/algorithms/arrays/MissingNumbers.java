package algorithms.arrays;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:00 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/missing-numbers/problem
 */

public class MissingNumbers {

    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, Integer> arrMap = new TreeMap();
        TreeSet<Integer> diff = new TreeSet();

        for(int a : arr) {
            if(arrMap.containsKey(a)) {
                arrMap.put(a, arrMap.get(a) + 1);
            } else {
                arrMap.put(a, 1);
            }
        }

        for(int b : brr) {
            if(arrMap.containsKey(b)) {
                arrMap.put(b, arrMap.get(b) - 1);
            } else {
                diff.add(b);
            }
        }

        for(int key : arrMap.keySet()) {
            if(arrMap.get(key) != 0) {
                diff.add(key);
            }
        }

        return diff.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {

    }
}
