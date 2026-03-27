import java.io.*;
import java.util.*;

public class Main {
	//거리가 1이라서 단방향이고 bfs랑 dfs쓰면 될거같은데, 지금 나의 머리에는 다익스트라뿐..
	//그래서 Edge는 안만드는 다익스트라를 해보자.
	static int N, M, K, X;
	static List<Integer>[] graph;
	//최단 거리이기 때문에 bfs말고 다익으로 풀거라서 visited없이 dist만 만들자
	static int[] dist;
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());//시작점
		
		graph = new ArrayList[N+1];
		for(int i = 1; i<= N; i++)graph[i] = new ArrayList<>();
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		
		for(int i = 0; i< M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//단방향
			graph[a].add(b);
		}
		
		dijkstra(X);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=N; i++) {
			if(dist[i]==K) {
//				sb.append(dist[i]).append('\n');
				sb.append(i).append('\n');
			}
		}
        if (sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);
		
	}
	static void dijkstra(int start) {
		//pq필요없음. 다 가중치가 1이다.
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next: graph[cur]) {
				if(dist[next]== INF) {
					dist[next] = dist[cur]+1;
					q.offer(next);
				}
			}
			
		}
	}
}