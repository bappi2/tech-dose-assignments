package BLINDxx75xxProblems.ArrayProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    // https://leetcode.com/problems/top-k-frequent-elements/

    public int[] topKFrequent(int[] nums, int k) {
        int [] result = new int[k];

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i=0; i< nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) +1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> freq.get(a) - freq.get(b));
        for (int key: freq.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i =0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
    /*
           //sorting in descending order of values
        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


     */
}
