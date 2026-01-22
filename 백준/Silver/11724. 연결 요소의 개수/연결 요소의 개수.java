import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] graph;
	static int[] dist;
	static boolean[] visited;
	static int N, M;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		//graph와 dist선언
		graph = new ArrayList[N+1];
		for(int i =1; i<=N; i++)graph[i] = new ArrayList<>();
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//무방향= 양방향
			graph[a].add(b);
			graph[b].add(a);
			
		}
		int count = 0;

		for (int i = 1; i <= N; i++) {
		    if (!visited[i]) {
		        dfs(i);
		        count++;
		    }
		}
		System.out.println(count);
		
	}
	
	static void dfs(int cur) {
		visited[cur] = true;
	
		for(int next: graph[cur]) {
			if(!visited[next])		
				dfs(next);
		}
	}
}