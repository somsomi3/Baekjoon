// 3. dfs
import java.io.*;
import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int  i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(int cur, int[][] computers){
        //얘도 queue인가?

        visited[cur] = true;
        
        for(int next = 0; next <computers.length; next++){
            if(computers[cur][next] ==1 && !visited[next]) 
                dfs(next, computers);
        }
    }
}