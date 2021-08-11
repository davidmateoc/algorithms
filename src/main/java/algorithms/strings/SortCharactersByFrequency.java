package algorithms.strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Create by davidmateo
 * Date: 7/17/21
 * Time: 8:50 PM
 * Algorithm URL: https://leetcode.com/problems/sort-characters-by-frequency/
 */

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char current = maxHeap.remove();
            for(int i = 0; i < map.get(current); i++) {
                sb.append(current);
            }
        }

        return sb.toString();
    }

    @Test
    public void SortCharactersByFrequencyTest() {

    }
}

