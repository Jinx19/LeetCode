package code.leetcode.hashtable;

import edu.princeton.cs.algs4.In;

import java.util.*;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> hp = new HashMap<>();
       List<Integer> ret = new ArrayList<>();
       for(int num : nums){
           hp.put(num,hp.getOrDefault(num,0) + 1);
       }
       Comparator<Map.Entry<Integer,Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
           @Override
           public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
               return o1.getValue() - o2.getValue();
           }
       };

       Queue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(comparator);
       for(Map.Entry<Integer,Integer> map : hp.entrySet()){
           if(heap.size() < k){
               heap.offer(map);
           }else{
               Map.Entry<Integer,Integer> top = heap.peek();
               if(map.getValue() > top.getValue()){
                   heap.poll();
                   heap.offer(map);
               }
           }
       }
       while (!heap.isEmpty()){
           ret.add(heap.poll().getKey());
       }
       return ret;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        topKFrequentElements.topKFrequent(nums,2);
    }
}
