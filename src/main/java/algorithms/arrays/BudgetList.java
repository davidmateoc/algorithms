//package algorithms.arrays;
//
//
//import javafx.util.Pair;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//import java.util.TreeSet;
//
///**
// * Create by davidmateo
// * Date: 2021-08-08
// * Time: 11:21 PM
// * Algorithm URL: Amazon OA Shopping Options
// */
//
//public class BudgetList {
//
//    public static int amountOfCombinations(int[] A, int[] B, int[] C, int[] D, int budget) {
//        int numberOfCombinations = 0;
//
//        Set<Integer> dSet = new TreeSet();
//        for (int d : D) {
//            dSet.add(d);
//
//
//            for (int a : A) {
//                for (int b : B) {
//                    for (int c : C) {
//                        int maxRemainingNumber = budget - (a + b + c);
//                        if (dSet.contains(maxRemainingNumber))
//                            numberOfCombinations++;
//                    }
//                }
//            }
//        }
//
//        return numberOfCombinations;            //O(n^4)
//    }
//
//    public static long numWays(List<Integer> tops,
//                               List<Integer> skirts,
//                               List<Integer> shoes,
//                               List<Integer> jeans,
//                               int dolars) {
//
//        Map<Integer, Integer> sumMap = new TreeMap<>();
//        int res = 0;
//
//
//        for (int i = 0; i < tops.size(); i++) {
//            for (int j = 0; j < skirts.size(); j++) {
//                int part = tops.get(i) + skirts.get(j);
//                sumMap.put(part, sumMap.getOrDefault(part, 0) + 1);
//            }
//        }
//
//        int totalEntries = 0;
//        List<Pair<Integer, Integer>> dp = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : sumMap.entrySet()) {
//            totalEntries += entry.getValue();
//            dp.add(new Pair<>(entry.getKey(), totalEntries));
//        }
//
//
//        for (int i = 0; i < shoes.size(); i++) {
//            for (int j = 0; j < jeans.size(); j++) {
//                int secondPart = shoes.get(i) + jeans.get(j);
//                int left = dolars - secondPart;
//                int dpIndex = search(dp, left);
//                if (dpIndex != -1) {
//                    res += dp.get(dpIndex).getValue();
//                }
//            }
//        }
//
//        return res;
//    }
//
//    private static int search(List<Pair<Integer, Integer>> list, int target) {
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (list.get(i).getKey() <= target) return i;
//        }
//        return -1;
//    }
//
//    public static int getNumberOfOptions(int[] priceOfJeans,
//                                  int[] priceOfShoes,
//                                  int[] priceOfSkirts,
//                                  int[] priceOfTops,
//                                  int dollar) {
//        int rst = 0;
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int priceOfJean : priceOfJeans) {
//            for (int priceOfShoe : priceOfShoes) {
//                int sum = priceOfJean + priceOfShoe;
//                map.put(sum, map.getOrDefault(sum, 0) + 1);
//            }
//        }
//
//        for (int priceOfSkirt : priceOfSkirts) {
//            for (int priceOfTop : priceOfTops) {
//                int sum = priceOfSkirt + priceOfTop;
//                Integer curr = map.ceilingEntry(dollar - sum).getValue();
//                rst += curr == null ? 0 : curr;
//            }
//        }
//        return rst;
//    }
//
//    public static void main(String[] args) {
////
////        int[] A = {1, 7, 8};
////        int[] B = {1, 3, 6};
////        int[] C = {1, 2, 4, 5, 3, 2, 1};
////        int[] D = {2, 3, 4, 5, 3};
////        int budget = 10;
//
////        amountOfCombinations(A, B, C, D, budget);
//
//        List<Integer> tops = List.of(1, 2);
//        List<Integer> skirts = List.of(2, 3);
//        List<Integer> shoes = List.of(4);
//        List<Integer> jeans = List.of(2, 3);
//        int dolars = 10;
//        long result = numWays(tops, skirts, shoes, jeans, dolars);
//        System.out.println(result);
//
//
//        int[] topsArray = {1, 2};
//        int[] skirtsArray = {2, 3};
//        int[] shoesArray = {4};
//        int[] jeansArray = {2, 3};
//        int resultArray = getNumberOfOptions(jeansArray, shoesArray, skirtsArray, topsArray, dolars);
//        System.out.println(resultArray);
//    }
//}
