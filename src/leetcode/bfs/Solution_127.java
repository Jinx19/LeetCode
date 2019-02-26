package code.leetcode.bfs;

import java.util.*;

public class Solution_127 {
    private int M,N;
    private List<Integer> getAdj(String word, List<String> wordList){
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            String adj = wordList.get(i);
            if(!word.equals(adj)){
                int count = 0;
                for(int j = 0 ; j < M; j++){
                    if(word.charAt(j) != adj.charAt(j)){
                        count++;
                    }
                }
                if(count == 1){
                    list.add(i);
                }
            }
        }
        return list;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        N = wordList.size();
        M = beginWord.length();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        Map<String,List<Integer>> hashmap = new HashMap<>();
        hashmap.put(beginWord,getAdj(beginWord,wordList));
        for(int i = 0 ; i < N; i++){
            String word = wordList.get(i);
            hashmap.put(word,getAdj(word,wordList));
        }

        q.offer(-1);
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0 ; j < size ; j++){
                int wordIndex = q.poll();
                String word = wordIndex == -1 ? beginWord : wordList.get(wordIndex);
                if(word.equals(endWord)){
                    return step;
                }
                if(wordIndex == -1 || !visited[wordIndex]){
                    if(wordIndex != -1){
                        visited[wordIndex] = true;
                    }
                    List<Integer> list = hashmap.get(word);
                    for(int i = 0 ; i < list.size(); i++){
                        int index = list.get(i);
                        if(!visited[index]){
                            q.offer(index);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution_127 solution_127 = new Solution_127();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("cog");
        list.add("log");
        System.out.println(solution_127.ladderLength("hit","cog",list));
    }
}
