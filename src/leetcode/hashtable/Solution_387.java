package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_387 {
    public int firstUniqChar(String s) {
        if(s == null || s.length() < 1){
            return -1;
        }
        if(s.length() == 1){
            return 0;
        }
        ArrayList<Integer> ls = new ArrayList<>();
        HashMap<Character,Integer> hs = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(hs.containsKey(s.charAt(i))){
                hs.remove(hs.get(s.charAt(i)));
                continue;
            }
            hs.put(s.charAt(i),i);
            ls.add(i);
        }

        return ls.size() > 0 ? ls.get(ls.size() - 1) : - 1;
    }
}
