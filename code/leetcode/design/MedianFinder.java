package leetcode.design;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mac on 2018/9/12.
 */
public class MedianFinder {
    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;
    private int count;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        count = 0;
    }

    public void addNum(int num) {
        count++;
        if((count & 1 )== 0){
            if(maxHeap.size() > 0 && num < maxHeap.peek()){
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        }else{
            if(minHeap.size() > 0 && num > minHeap.peek()){
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public double findMedian() {
        double mid = 0;
        if((count&1)==0){
            mid = (minHeap.peek() + maxHeap.peek())/2.0;
        }else{
            mid = maxHeap.peek();
        }
        return mid;
    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}
