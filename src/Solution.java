package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
//    int minDistance(int dist[], boolean sptSet[]) {
//        int min = Integer.MAX_VALUE;
//        int v = dist.length;
//        int min_index = -1;
//        for (int i = 0; i < v; i++) {
//            if (!sptSet[i]&& dist[i] < min) {
//                min = dist[i];
//                min_index = i;
//            }
//        }
//        return min_index;
//    }
//    void dijkstra(int graph[][], int source) {
//        int i, j;
//        int v = graph.length;
//        boolean[] s = new boolean[v];
//        int[] dist = new int[v];
//        // 初始化，集合s只有source，如果存在source到点的边则dist[i]=graph[source][i]
//        for (i = 0; i < v; i++) {
//            if (i != source && graph[source][i] != 0) {
//                dist[i] = graph[source][i];
//            } else {
//                dist[i] = Integer.MAX_VALUE;
//            }
//
//            if (i == source) {
//                s[i] = true;
//            } else {
//                s[i] = false;
//            }
//        }
//        dist[source] = 0;
//
//        for (int count = 0; count < v - 1; count++) {
//            int u = minDistance(dist, s);
//            s[u] = true;
//            for (j = 0; j < v; j++) {
//                if (!s[j]) {
//                    if (graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j]) {
//                        dist[j] = dist[u] + graph[u][j];
//                    }
//                }
//            }
//        }
//
//        if(dist[v-1] <= 2){
//            System.out.println("POSSIBLE");
//        }else{
//            System.out.println("IMPOSSIBLE");
//        }
//    }
    public ArrayList<Integer> getsidenode(int[][] graph,int node){
        int v = graph.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < v; i++){
            if(graph[node][i] == 1){
                arrayList.add(i);
            }
        }
        return arrayList;
    }
    public void bfs(int[][] graph,int[] dist){
        Queue<Integer> q = new LinkedList<>();
        dist[0] = 0;
        q.add(0);
        boolean isPossible = false;
        while (!q.isEmpty()){
            int top = q.poll();
            if(top == graph.length - 1 && dist[top] <= 2){
                isPossible = true;
                break;
            }
            for(int node : getsidenode(graph,top)){
                if(dist[node] == 0){
                    dist[node] =  dist[top] + 1;
                    q.add(node);
                }
            }
        }
        if(isPossible){
            System.out.println("POSSIBLE");
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i = 0; i < count; i++){
            int n  = sc.nextInt();
            int m = sc.nextInt();
            int[][] graph = new int[n][n];
            int[] dist = new int[n];
            for(int j = 0; j < m; j++){
                int start = sc.nextInt()-1;
                int end = sc.nextInt()-1;
                graph[start][end] = 1;
                dist[j] = Integer.MAX_VALUE;
            }
            solution.bfs(graph,dist);
        }
    }
}