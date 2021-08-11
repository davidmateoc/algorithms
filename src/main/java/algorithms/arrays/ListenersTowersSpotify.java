package algorithms.arrays;

import org.junit.Test;

import java.util.TreeSet;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:32 PM
 * Algorithm URL: 
 */

public class ListenersTowersSpotify {

    public int minTowerCoverage(int[] listeners, int[] towers) {
        int minCoverage = 0;

        for(int listener : listeners) {
            int minDistanceToATower = Integer.MAX_VALUE;
            for(int tower : towers) {
                int distanceBetweenListenerAndTower = Math.abs(listener - tower);
                if(distanceBetweenListenerAndTower < minDistanceToATower) {
                    minDistanceToATower = distanceBetweenListenerAndTower;
                }
            }

            if(minCoverage < minDistanceToATower) {
                minCoverage = minDistanceToATower;
            }
        }

        return minCoverage;
    }

    public int minTowerCoverageDifferentAPproach(int[] listeners, int[] towers) {
        TreeSet<Integer> towersSet = new TreeSet();
        for(int tower : towers) {
            towersSet.add(tower);
        }

        int minCoverage = 0;
        for(int listener : listeners) {
            int distanceToNextTower = (towersSet.ceiling(listener) == null)? Integer.MAX_VALUE : towersSet.ceiling(listener) - listener;
            int distanceToPrevTower = ((towersSet.floor(listener) == null)? Integer.MAX_VALUE : listener - towersSet.floor(listener));
            int minDistanceToTower = Math.min(distanceToNextTower, distanceToPrevTower);
            if(minCoverage < minDistanceToTower) {
                minCoverage = minDistanceToTower;
            }
        }
        return minCoverage;
    }

    @Test
    public void minTowerCoverageTest() {
        int[] listeners = new int[]{1, 11, 5, 20};
        int[] towers = new int[]{4, 8, 15};

        System.out.println(minTowerCoverage(listeners, towers));
    }

    @Test
    public void minTowerCoverageDifferentAPproachTest() {
        int[] listeners = new int[]{1, 11, 5, 20};
        int[] towers = new int[]{4, 8, 15};

        System.out.println(minTowerCoverageDifferentAPproach(listeners, towers));
    }
}
