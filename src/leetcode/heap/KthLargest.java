package leetcode.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

class KthLargest {

    private PriorityQueue<Integer> queue;
    private int k;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<Integer>();
        this.k = k;
        for(int i = 0 ;i < nums.length; i++){
            queue.offer(nums[i]);
        }
    }

    public int add(int val) {
        queue.offer(val);
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < k; i++){
            array.add(queue.poll());
        }

        for(int i = 0 ; i < k; i++){
            queue.add(array.get(i));
        }

        return array.get(k - 1);
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,5,8,2};
        KthLargest kthLargest = new KthLargest(3, arr);

        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */