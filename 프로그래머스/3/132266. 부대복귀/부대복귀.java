import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        // int start = destination;
        //애초에 그냥 destination을 가져와서 쓰면 되는 거임.
        
        List<Integer>[]graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        //그래프 입력
        for(int[] r: roads){
            //양방향을 roads에서 빼와
            graph[r[0]].add(r[1]);
            graph[r[1]].add(r[0]);
        }

        //답을 낼 세는 배열 dist
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
            
        // bfs(start);
        //bfs호출 없는 그냥 구현
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(destination);
        dist[destination] =0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next: graph[cur]){
                if(dist[next]==-1){
                   dist[next] =dist[cur]+1;
                    q.offer(next);
                }

            }
        }
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}