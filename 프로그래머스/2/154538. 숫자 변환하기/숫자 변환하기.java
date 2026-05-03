import java.io.*;
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<Integer> q =new LinkedList<>();
        int[] dist = new int[y+1];
        Arrays.fill(dist, -1);
            
        q.offer(x);
        dist[x] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            if(cur == y)return dist[cur];
            
            int[] method = { cur+n, cur*2, cur*3};
            for (int nx : method) {
                if(nx >y)continue;
                if(dist[nx] != -1)continue;
                
                dist[nx] = dist[cur]+1;
                q.offer(nx);
            }
        }
        
        return -1;
    }
}