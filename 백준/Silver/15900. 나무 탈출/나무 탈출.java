import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] dist;
	
	//여기서 sum을 0으로 초기화: 아무 것도 더하지 않은 상태 = 0
	static int sum= 0;
	
	//depth 계산이 주인 문제 이므로, parent나 child는 필요 없을 것 같다.
//	static int[] parent;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		//그래프와 dist, visited 등 필요한 것들 만들기
		graph = new ArrayList[N+1]; //트리? 그래프? 는 1부터 시작하는 경우가 많다.
		for(int i=1; i<=N; i++)graph[i]= new ArrayList<>();
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
			
		}
		// 1번 정점은 '루트 노드'라고 문제에서 주어졌으므로, 
		//dfs 에 1을 넣어보자. 그리고 새로운 변수 depth=0
		dfs(1, 0);
				
		//출력
		System.out.println(sum%2==1? "Yes":"No");
				
	}
	static void dfs(int start, int depth) {
		//1에서 leaf를 향해 내려가고 있으니까. 
		//각각의 leaf에 1부터 쌓아왓던 depth가 쌓이는 거
		visited[start] = true;
		boolean leaf = true;
		
		//nxt가 없는 경우는 그냥 for문을 안돌고 끝나는 거
		for(int nxt:graph[start]) {
			if(!visited[nxt]) {
				leaf = false;
				dfs(nxt, depth+1);
			}
		}
		//for문을 다돌고 난다음에도, leaf= true;라면,
		if(leaf) sum+= depth;
	}
}