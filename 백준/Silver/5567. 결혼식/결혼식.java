import java.io.*;
import java.util.*;

public class Main {
	static int[] dist;
	static List<Integer>[] graph;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		//그래프와 dist, visited?
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++)graph[i] = new ArrayList<>();
		
		dist = new int[n+1];
		Arrays.fill(dist, -1);
		
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
			
		}
		
		bfs(1); //항상 상근이는 1번이다.
		//dfs가 아닌 이유는 다 가봐야한다. 친구마다 친구를.
		
		//출력 dist 가 2인 
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (dist[i] == 1 || dist[i] == 2) count++;
        }

        System.out.println(count);
    }
		
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if (dist[cur] == 2) continue;

	        for (int next : graph[cur]) {
	            if (dist[next] == -1) {
	                dist[next] = dist[cur] + 1;
	                q.add(next);
	            }
	        }
	    }
	}
}