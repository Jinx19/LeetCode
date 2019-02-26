package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution TopN：求给定的N个有序数组里最大的K个数
 */
class Node {
    public long value;
    public int rowId, colId;

    public Node(long v, int row, int col) {
        this.value = v;
        this.rowId = row;
        this.colId = col;
    }
}

//使用优先队列
public class Solution {
    long[] topn(long[][] array, int k) {
        long[] ret = new long[k];
        if (array == null || array.length == 0) {
            return ret;
        }
        int m = array.length;
        PriorityQueue<Node> heap = new PriorityQueue<Node>(k, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if(b.value > a.value){
                    return 1;
                }else if(b.value < a.value){
                    return  -1;
                }else{
                    return 0;
                }
            }
        });

        for (int i = 0; i < m; i++) {
            if (array[i].length > 0) {
                int rowId = i;
                int colId = array[i].length - 1;
                long value = array[i][colId];
                heap.add(new Node(value, rowId, colId));
            }
        }

        for (int i = 0; i < k; i++) {
            Node temp = heap.poll();
            int rowId = temp.rowId;
            int colId = temp.colId;
            long value = temp.value;

            ret[i] = value;

            if (colId > 0) {
                colId--;
                value = array[rowId][colId];
                heap.add(new Node(value, rowId, colId));
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long[][] array = {{1,3,10}, {2,6,8}, {1,5,11}};
        for (long i : solution.topn(array, 4)) {
            System.out.println(i);
        }
    }

}