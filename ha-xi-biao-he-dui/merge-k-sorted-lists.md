# 23.Merge k Sorted Lists

```
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

方法 一: 使用 PriorityQueue

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.PriorityQueue;
import java.util.Comparator;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        PriorityQueue pq = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>() {
          @Override
          public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
          }
        });

        ListNode head = new ListNode(0);
        ListNode dummpy = head;

        for(int i = 0 ; i < lists.length; i++){
            if(lists[i] == null){
                continue;
            }
            pq.add(lists[i]);
        }

        while(!pq.isEmpty()){
          ListNode smallestNode = (ListNode)pq.poll();
          dummpy.next = new ListNode(smallestNode.val);
          dummpy = dummpy.next;
          if(smallestNode.next != null){
            pq.add(smallestNode.next);
          }
        }

        return head.next;
    }
}
```

时间复杂度:O\(NlogK\)



