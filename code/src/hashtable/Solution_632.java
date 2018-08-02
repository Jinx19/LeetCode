package hashtable;

import java.util.*;

/**
 * Created by mac on 2018/6/22.
 */
public class Solution_632 {
    //指针暴力解法
    public static int[] smallestRange(List<List<Integer>> nums) {
        int i;
        int k = nums.size();
        int range = Integer.MAX_VALUE;
        int[] ptr = new int[k];
        for (i = 0; i < k; i++) {
            ptr[i] = 0;
        }
        int left = -1;
        int right = -1;
        while (true) {
            int minind = -1;
            int minval = Integer.MAX_VALUE;
            int maxval = Integer.MIN_VALUE;
            int flag = 0;

            for (i = 0; i < k; i++) {
                int n = nums.get(i).size();
                if (ptr[i] == n) {
                    flag = 1;
                    break;
                }

                if (ptr[i] < n && nums.get(i).get(ptr[i]) < minval) {
                    minval = nums.get(i).get(ptr[i]);
                    minind = i;
                }

                if (ptr[i] < n && nums.get(i).get(ptr[i]) > maxval) {
                    maxval = nums.get(i).get(ptr[i]);
                }
            }

            if (flag == 1) {
                break;
            }

            ptr[minind]++;

            if (maxval - minval < range) {
                left = minval;
                right = maxval;
                range = right - left;
            }

        }

        return new int[]{left, right};
    }
    public class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[] smallestRange2(List<List<Integer>> nums) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (a.x - b.x));
        int size = nums.size();
        int[] idxArr = new int[size];
        int max = 0;
        for (int i = 0; i < size; i++) {
            int num = nums.get(i).get(0);
            pq.add(new Point(num, i));
            max = Math.max(max, num);
        }
        int start = -1, end = -1, gap = Integer.MAX_VALUE;
        while (pq.size() == size) {
            Point first = pq.poll();
            int min = first.x, idx = first.y;
            if (max - min < gap) {
                gap = max - min;
                start = min;
                end = max;
            }
            if (++idxArr[idx] < nums.get(idx).size()) {
                first.x = nums.get(idx).get(idxArr[idx]);
                pq.add(first);
                max = Math.max(max, first.x);
            }
        }
        return new int[]{start, end};
    }


    public static void main(String[] args) {
        int[] list1 = {4,10,15,24,26};
        int[] list2 = {0,9,12,20};
        int[] list3 = {5,18,22,30};

        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i : list1){
            list.add(i);
        }

        nums.add(list);
        list = new ArrayList<>();

        for(int i : list2){
            list.add(i);
        }

        nums.add(list);
        list = new ArrayList<>();
        for(int i : list3){
            list.add(i);
        }

        nums.add(list);
        list = new ArrayList<>();

        Solution_632 solution_632 = new Solution_632();
        for(int i : solution_632.smallestRange2(nums)){
            System.out.println(i);
        }
    }
}
