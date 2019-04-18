package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
public class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;


    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int n = maxHeap.size() + minHeap.size();
        if(n % 2 == 0){
            if(maxHeap.size() > 0 && num < maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }else{
            if(minHeap.size() >0 && num > minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public double findMedian() {
        int n = maxHeap.size() + minHeap.size();
        if(n % 2 == 0){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }else{
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
//        medianFinder.addNum(2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
