import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
        dist = new int[100001];
        
        
        bfs(N);
        
        System.out.println(dist[K]);
		
		
	}
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
            if (cur == K) return;
			
			int[] next = {cur-1, cur+1, cur*2};
			
			for(int daum : next) {
				if(daum<0||daum>100000)continue;
				if(visited[daum])continue;
				
				visited[daum]= true;
				q.offer(daum);
				dist[daum] = dist[cur]+1;
				
			}
			
		}
		
	}
}