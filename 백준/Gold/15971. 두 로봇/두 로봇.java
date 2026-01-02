import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int to;
		int cost;
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	
	static List<Node>[] graph;
	static boolean[] visited;
	static int[] dist;
	
	static int sum = 0;
	static int mmax = 0;
	static int a, b, cost;
    static int room2;
    static int answer = 0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int room1 = Integer.parseInt(st.nextToken());
		room2 = Integer.parseInt(st.nextToken());
		
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
		
		for(int i =0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, cost));
			graph[b].add(new Node(a, cost));
		}
		
		
        dfs(room1, 0, 0);
		
        System.out.println(answer);
	}
	
    static void dfs(int cur, int sum, int maxEdge) {
		 if (cur == room2) {
	            answer = sum - maxEdge;
	            return;
        }
		//cost값을 계속 누적
		visited[cur] = true;
		
		for(Node nxt: graph[cur]) {
			if(!visited[nxt.to]) {
				 dfs(nxt.to, sum + nxt.cost, Math.max(maxEdge, nxt.cost));
			}
		}
		
	}

}