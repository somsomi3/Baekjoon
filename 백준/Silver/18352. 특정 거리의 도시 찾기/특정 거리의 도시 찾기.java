import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, X;
	
	static List<Integer>[] graph;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)graph[i]= new ArrayList<>();
		
		visited = new boolean[N+1];
		dist = new int[N+1];
//		Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(dist, -1);
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
		}

		dijkstra(X);
		
		boolean flag = false;
		for(int i = 1; i <= N; i++) {
			if(dist[i]==K) {
				System.out.println(i);
				flag = true;
			}
		}
		if(!flag)System.out.println(-1);
	}
	
	static void dijkstra(int start) {
//		PriorityQueue<Integer>[] pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		dist[start] = 0;
		q.add(start);
		
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : graph[cur]) {
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}