package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by mac on 2018/7/17.
 */
public class KthSmalest {
    public void exch(int[] a, int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public int partition(int[] a,int lo, int hi){
        int p = a[lo];
        int i = lo;
        int j = hi + 1;
        while(true){
            while(a[++i] < p)
                if(i == hi) break;
            while(a[--j] > p)
                if(j == lo) break;
            if(i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k <= 0 || k > input.length){
            return list;
        }
        int start = 0,end = input.length - 1;
        int index = partition(input,start,end);
        while(index != k - 1){
            if(index > k - 1){
                end = index - 1;
                if(start == end)
                    index = end;
                else
                    index = partition(input,start,end);
            }else{
                start = index + 1;
                if(start == end)
                    index = start;
                else
                    index = partition(input,start,end);
            }
        }
        for(int i = 0 ; i < k ; i++){
            list.add(input[i]);
        }
        Collections.sort(list);
        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o2 - o1;
            }
        });

        if(input == null ||k <=0 || k > input.length){
            return list;
        }

        for(int i = 0 ; i < input.length; i++){
            if(pq.size() < k){
                pq.add(input[i]);
            }else{
                if(input[i] < pq.peek()){
                    pq.poll();
                    pq.add(input[i]);
                }
            }
        }
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        KthSmalest kthSmalest = new KthSmalest();
        int[] nums = {4,5,1,6,2,7,3,8};
        int k = 5;
        ArrayList<Integer> list = kthSmalest.GetLeastNumbers_Solution2(nums,k);
        for(int i : list){
            System.out.println(i);
        }

    }
}
