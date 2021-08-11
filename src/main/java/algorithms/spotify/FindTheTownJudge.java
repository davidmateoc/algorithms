package algorithms.spotify;

import org.junit.Test;

import java.util.HashMap;

/**
 * Create by davidmateo
 * Date: 7/25/21
 * Time: 5:49 PM
 * Algorithm URL: https://leetcode.com/problems/find-the-town-judge/
 */

public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0) {
            if(n == 1) {
                return 1;
            }
            return -1;
        }

        HashMap<Integer, Integer> personTrustedXTimes = new HashMap();
        for(int[] people : trust) {
            personTrustedXTimes.put(people[1], personTrustedXTimes.getOrDefault(people[1], 0) + 1);
        }
        for(int personTrusted : personTrustedXTimes.keySet()) {
            if(personTrustedXTimes.get(personTrusted) == (n - 1)) {
                for(int i = 0; i < trust.length; i++) {
                    if(trust[i][0] == personTrusted) {
                        return -1;
                    }
                }
                return personTrusted;
            }
        }
        return -1;
    }

    public static int findJudge4(int N, int[][] trust) {

        int[] degree = new int[N+1];

        for( int[] i : trust){
            degree[i[0]]--;
            degree[i[1]]++;
        }

        for( int i =1 ; i <= N ; i++)
            if(degree[i] == N-1)
                return i;


        return -1;
    }

    @Test
    public void FindTheTownJudgeTestA() {
        int[][] trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        System.out.println(findJudge(3, trust));
        System.out.println(findJudge4(3, trust));
    }

    @Test
    public void FindTheTownJudgeTestB() {
        int[][] trust = new int[][]{{1, 2}};
        System.out.println(findJudge(2, trust));
        System.out.println(findJudge4(2, trust));
    }
}

