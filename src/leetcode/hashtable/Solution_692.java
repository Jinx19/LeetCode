package leetcode.hashtable;

import java.util.*;

/**
 * Created by mac on 2018/6/26.
 * Top K Frequent Words
 */
public class Solution_692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Comparator<Map.Entry<String,Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        Map<String, Integer> sf = new TreeMap<>();
        for (String s : words) {
            if (sf.containsKey(s)) {
                sf.put(s,sf.get(s) + 1);
            }else{
                sf.put(s,1);
            }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(sf.entrySet());

        Collections.sort(list,valueComparator);
        for(Map.Entry<String,Integer> entry : list){
            if(k-- > 0){
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_692 solution_692 = new Solution_692();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        for(String str : solution_692.topKFrequent(words,k)){
            System.out.printf(str);
        }

    }
}
