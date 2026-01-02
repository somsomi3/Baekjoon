import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int child;
		int cost;
		
		Node(int child, int cost){
			this.child = child;
			this.cost = cost;
		}
	}
	
	static List<Node>[] graph;
	static boolean[] visited;
	static int[] dist;
	
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		//그래프와 visited, dist초기화하기, 노드가 1부터 시작하므로  [N+1]이다.
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++)graph[i]= new ArrayList<>();
		visited = new boolean[n+1];
		dist = new int[n+1];
		//두번째 dfs이전에 배열 초기화 필요.
		Arrays.fill(visited, false);
		Arrays.fill(dist, 0);
		
		for(int i =0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//부모와 자식이 정해져 있으므로, 방향 하나만 해야할듯? =>X!!!!
			//말만 부모자식이지, 양방향으로 왓다갔다가 가능함.
			graph[p].add(new Node(c, cost));
			graph[c].add(new Node(p, cost));
		}
		
		//그냥 1번을 루트라고 하진 않았지만 1에서 dfs한번돌고,
		//그결과로 dfs를 한번더돌려면.,.. 코드를 어떻게 적어야 하지..
		dist[1] = 0;
		dfs(1);
		
		int farNode = 1;
        
		//두번째 dfs에 들어갈 인덱스를 찾아 줘야함.
		for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[farNode]) farNode = i;
        }

        Arrays.fill(visited, false);
        Arrays.fill(dist, 0);

        dfs(farNode);

        int diameter = 0;
        for (int i = 1; i <= n; i++) {
            diameter = Math.max(diameter, dist[i]);
        }

        System.out.println(diameter);
    }
	static void dfs(int cur) {
		visited[cur] = true;
		
		for(Node nxt: graph[cur]) {
			if(!visited[nxt.child]) {
				dist[nxt.child] = dist[cur]+ nxt.cost;
				dfs(nxt.child);
			}
		}
	}
}