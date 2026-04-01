import java.io.*;
import java.util.*;

class Solution {
    static class Edge{
        int from, to, cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    static int[] parent;
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB){
            parent[rootB]= rootA;
        }
    }
    static int find(int x){
        if(parent[x]==x)return x;
        return parent[x]= find(parent[x]);
    }
    
    public int solution(int n, int[][] costs) {
        int result = 0;
        
        parent = new int[n+1];
        for(int i = 1; i<n; i++)parent[i] = i;//초기값설정
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)->a.cost- b.cost);
        
        for(int i = 0; i<costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            
            pq.offer(new Edge(a, b, c));
        }
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(find(cur.from)!= find(cur.to)){
                union(cur.from, cur.to);
                result += cur.cost;
            }    
        }
        
        return result;
    }
}