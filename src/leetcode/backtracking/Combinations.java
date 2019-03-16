package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations {
    public void helper(List<List<Integer>> ret, int start,int n, int k, List<Integer> path){
        if(k == 0){
            Collections.sort(path);
            ArrayList add = new ArrayList<>(path);
            Collections.sort(add);
            if(!ret.contains(add)){
                ret.add(add);
            }
            return;
        }

        if(path == null){
            path = new ArrayList<>();
        }
        for(int i = start; i<= n; i++){
            path.add(i);
            helper(ret,i + 1,n, k - 1, path);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n == 0 || k == 0){
            return ret;
        }
        helper(ret,1,n,k,null);
        return ret;
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combine(13,13);

    }
}