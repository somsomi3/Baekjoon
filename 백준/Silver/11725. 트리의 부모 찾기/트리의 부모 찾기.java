import java.io.*;
import java.util.*;

public class Main {
	//a, b밖에 없어서 노드를 만들 필요성을 느끼지 못함.
	
	static List<Integer>[] graph;
	//그래프는 어떻게 생긴걸까? 밑에서 ArrayList<>()해주는 이유는? 왜 [N+1]이 아닌가?
	static int[] parent;
	static boolean[] visited;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		for(int i =1; i<=N; i++) graph[i]= new ArrayList<>();
		
        for (int i = 0; i < N - 1; i++) { // 간선은 N-1개
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
			
		}
		parent = new int[N+1];//선언
		visited = new boolean[N+1];
		//자동으로 false로 채워짐
		
		//부모찾기 루트는 항상1인데 왜 부모를 1부터 찾..?..
		dfs(1);
		
		//한줄씩 답을 출력한걸 보면, StringBuilder을 써야하는 거같다.. 
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++) {// 루트는 부모가 없어서 초기값인 0그대로 이다
			sb.append(parent[i]).append('\n');
		}
		System.out.println(sb);
		
	}
	static void dfs(int cur) {
		visited[cur] = true;
		for(int next: graph[cur]) {
			if(!visited[next]) {
				parent[next]= cur;
				dfs(next);
			}
		}
	}

}
