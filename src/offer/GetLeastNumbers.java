package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if(input == null || input.length == 0){
            return arrayList;
        }

        if(k <= 0 || input.length <= 0 || k > input.length){
            return arrayList;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i : input){
            if(priorityQueue.size() < k){
                priorityQueue.offer(i);
            }else if(priorityQueue.size() == k && priorityQueue.peek() > i){
                priorityQueue.poll();
                priorityQueue.offer(i);
            }
        }
        for(int i : priorityQueue){
            arrayList.add(i);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] nums = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = getLeastNumbers.GetLeastNumbers_Solution(nums,4);
        for(int i : res){
            System.out.println(i);
        }
    }
}
