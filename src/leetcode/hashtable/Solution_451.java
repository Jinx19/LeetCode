package leetcode.hashtable;

import java.util.*;

public class Solution_451 {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

//        int[] count = new int[256];
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i)]++;
//        }
//
//        TreeMap<Integer, LinkedList<Character>> sorted = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        for (int i = 0; i < 256; i++) {
//            int frequency = count[i];
//            char c = (char)i;
//            if (frequency!=0 && sorted.containsKey(frequency)&&!sorted.get(frequency).contains(c)) {
//                sorted.get(frequency).offer(c);
//            } else {
//                LinkedList<Character> linkedList = new LinkedList<>();
//                linkedList.offer(c);
//                sorted.put(frequency, linkedList);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry entry : sorted.entrySet()) {
//            int freq = (int)entry.getKey();
//            for(Character c : (LinkedList<Character>)entry.getValue()){
//                for(int i = 0; i < freq; i++){
//                    sb.append(c);
//                }
//            }
//
//        }
//        return sb.toString();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_451 s = new Solution_451();
        System.out.println(s.frequencySort("tree"));
    }
}
