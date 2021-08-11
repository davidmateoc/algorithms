package algorithms.spotify;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Create by davidmateo
 * Date: 7/17/21
 * Time: 5:37 PM
 * Algorithm URL: https://leetcode.com/problems/analyze-user-website-visit-pattern/
 */

public class AnalyzeUserWebsiteVisitPattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        Map<String, TreeMap<Integer, String>> map = new HashMap<>(); // <username, <timestamp, website>>
        for (int i = 0; i < username.length; i++)
        {
            map.putIfAbsent(username[i], new TreeMap<>());
            map.get(username[i]).put(timestamp[i], website[i]);
        }

        TreeMap<String, Integer> seqMap = new TreeMap<>();

        for (TreeMap<Integer, String> treeMap : map.values())
        {
            List<String> list = new ArrayList<>();

            for (String web : treeMap.values()) {
                list.add(web);
            }

            Set<String> seqs = generate3Seq(list);

            for (String seq : seqs) {
                seqMap.put(seq, seqMap.getOrDefault(seq, 0) + 1);
            }
        }

        // Find the subsequence with the max number of user visits
        int maxCnt = 0;
        String maxSeq = "";

        for (String key : seqMap.keySet())
        {
            int cnt = seqMap.get(key);

            if (cnt > maxCnt)
            {
                maxCnt = cnt;
                maxSeq = key;
            }
        }

        return Arrays.asList(maxSeq.split(" "));
    }

    // Generate 3-length subsequence
    private Set<String> generate3Seq(List<String> websitesList)
    {
        Set<String> setOfListSeq = new HashSet<>();

        for (int i = 0; i < websitesList.size(); i++)
        {
            for (int j = i+1; j < websitesList.size(); j++)
            {
                for (int k = j+1; k < websitesList.size(); k++)
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(websitesList.get(i)).append(" ");
                    sb.append(websitesList.get(j)).append(" ");
                    sb.append(websitesList.get(k));
                    setOfListSeq.add(sb.toString());
                }
            }
        }

        return setOfListSeq;
    }

    @Test
    public void AnalyzeUserWebsiteVisitPatternTest() {
        String[] username = new String[]{"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = new int[]{1,2,3,4,5,6,7,8,9,10};
        String[] website = new String[]{"home","about","career","home","cart","maps","home","home","about","career"};

        mostVisitedPattern(username, timestamp, website);

    }
}

