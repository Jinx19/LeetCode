### 127.Word Ladder

Given two words \(_beginWord\_and\_endWord_\), and a dictionary's word list, find the length of shortest transformation sequence from_beginWord\_to\_endWord_, such that:

1. Only one letter can be changed at a time.
2. Each transformed word must exist in the word list. Note that \_beginWord \_is \_not \_a transformed word.

**Note:**

* Return 0 if there is no such transformation sequence.
* All words have the same length.
* All words contain only lowercase alphabetic characters.
* You may assume no duplicates in the word list.
* You may assume \_beginWord \_and \_endWord \_are non-empty and are not the same.

**Example 1:**

```
Input:

beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]


Output: 
5
Explanation:
 As one shortest transformation is "hit" ->"hot" ->"dot" ->"dog" ->"cog",return its length 5.
```

**Example 2:**

```
Input:

beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]


Output:
 0


Explanation:
 The endWord "cog" is not in wordList, therefore no possible
transformation.
```

```java
class Solution {
    private int M,N;
    private List<Integer> getAdj(String word,List<String> wordList){
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
}
```

优化



```py
class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        if endWord not in wordList:
            return 0
        wordDict = set(wordList)
        length = 2
        front, back = set([beginWord]), set([endWord])
        wordDict.discard(beginWord)
        while front:
            # generate all valid transformations
            front = wordDict & (set(word[:index] + ch + word[index+1:] for word in front 
                                for index in range(len(beginWord)) for ch in 'abcdefghijklmnopqrstuvwxyz'))
            if front & back:
                # there are common elements in front and back, done
                return length
            length += 1
            if len(front) > len(back):
                # swap front and back for better performance (fewer choices in generating nextSet)
                front, back = back, front
            # remove transformations from wordDict to avoid cycle
            wordDict -= front
        return 0
```



