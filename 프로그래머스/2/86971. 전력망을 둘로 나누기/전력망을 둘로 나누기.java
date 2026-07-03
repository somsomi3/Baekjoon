import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count;
    
    public int solution(int n, int[][] wires) {
        
        graph = new ArrayList[n+1];
        
        for(int i = 1; i<=n ; i++){
            graph[i] = new ArrayList<>();
            
        }
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = Integer.MAX_VALUE;
    
        for (int[] wire : wires) {

            int a = wire[0];
            int b = wire[1];

            visited = new boolean[n + 1];
            count = 0;

            dfs(1, a, b);

            int difference = Math.abs(count - (n - count));

            answer = Math.min(answer, difference);
        }

        return answer;
    }


    public void dfs(int current, int a, int b) {

        visited[current] = true;
        count++;

        for (int next : graph[current]) {
            if ((current == a && next == b) ||(current == b && next == a)) {
                continue;
            }

            if (visited[next]) {
                continue;
            }

            dfs(next, a, b);
        }
    }
}