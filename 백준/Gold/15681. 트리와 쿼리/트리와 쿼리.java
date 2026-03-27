import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] dist;
	static int[] child;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		
		//graph visited dist child
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++)graph[i] = new ArrayList<>(); //그래프의 인덱스는 1부터 시작한다.
		visited = new boolean[N+1];
		dist = new int[N+1];
		child = new int[N+1];
		
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		//가중치와 방향성이 없음.
		for(int i=0; i<N-1; i++) {//트리의 간선은 항상 N-1개이다.
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		dfs(R);// 루트에서 시작한다.
		
		
		for(int i= 0; i<Q; i++) {
			int x = Integer.parseInt(br.readLine());
			System.out.println(child[x]);
		}
	}
	static void dfs(int cur) {
		visited[cur] = true;
		child[cur] = 1;// 이걸 dfs(R)호출전에 넣고 호출해야 하나? 
		//왜냐면 항상 초기화 하면 안되잖아..? 아.. 항상 초기화 해야 각각의 nxt값만 더하는듯.
		
		for(int nxt: graph[cur]) {
			if(!visited[nxt]) {
				//nxt들 다돌고 와서
				dfs(nxt);
				//child[cur]에 child[nxt]를 더해주자.
				child[cur] +=child[nxt];
			}
		}
	}
}