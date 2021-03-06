package BLINDxx75xxProblems.HeapProblems;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i:nums){
            map.put(i,map.get(i)==null?1:map.get(i)+1);
        }

        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

        for (int n: map.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        int[] top_k =new int[heap.size()];
        int i=heap.size()-1;
        while (!heap.isEmpty())
            top_k[i--]=heap.poll();
        return top_k;
    }
}
