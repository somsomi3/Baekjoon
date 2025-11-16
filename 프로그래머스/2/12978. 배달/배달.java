import java.util.*;
class Solution {
   static class Node implements Comparable<Node>{
       int to, cost;
       Node(int to, int cost){
           this.to = to;
           this.cost = cost;
       }
       public int compareTo(Node o){
           return this.cost - o.cost;
       }
   }
    //입력 없어도되고
    public int solution(int N, int[][] road, int K) {
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N+1];
        List<Node>[] graph = new ArrayList[N+1];
        
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, INF);
        
        for(int[] r: road){
            int a =r[0], b=r[1], c=r[2];
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0; 
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curNode = cur.to;
            int curDist = cur.cost;
            
            if(curDist>dist[curNode])continue;
            for(Node next: graph[curNode]){
                if(curDist+next.cost<dist[next.to]){
                    dist[next.to] = curDist+next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        // 마을 수 count
        int count = 0;
        for(int i=1; i<=N; i++){
            if(dist[i]<=K){
                count++;
            }
        }
        return count;
    }
}