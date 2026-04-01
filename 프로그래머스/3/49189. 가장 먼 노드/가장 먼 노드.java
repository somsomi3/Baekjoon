import java.io.*;
import java.util.*;

class Solution {
    // static int[] dx = {-1, 1, 0, 0};
    // static int[] dy = {0, 0, -1, 1};
    
    static boolean[] visited;
    static int[] dist;
    static List<Integer>[] graph;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, 20001);
        
        graph = new ArrayList[n+1];
        for(int i = 1; i<=n; i++)graph[i] = new ArrayList<>();
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];

            graph[a].add(b);
            graph[b].add(a); // 양방향
        }
        
        bfs(1);
        int max = 0;
        for(int i = 1; i<=n; i++){
            max = Math.max(max, dist[i]);
        }
        int cnt = 0;
        for(int i = 1; i<=n; i++){
            if(dist[i]== max){
                cnt++;
            }
        }
        return cnt;
    }
    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next: graph[cur]){
                if(!visited[next]){
                    visited[next]= true;
                    dist[next]= dist[cur]+1;
                    q.offer(next);
                    
                }
            }
        }
        
    }
}
