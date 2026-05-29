// 2. BFS
import java.io.*;
import java.util.*;

class Solution {
//격자가 아닌 그래프BFS유형입니다. 그래서 방향벡터 필요없음.
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start, int[][] computers){
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int next =0; next< computers.length; next++){
                if(computers[cur][next] ==1 && !visited[next]){
                    
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}