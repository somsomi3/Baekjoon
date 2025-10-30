import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int N, R, Q;
	static int[] familly;
	static int count;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		//그래프 만들기, 그래프는 정점 1부터 시작하므로, i=1부터 시작함.
		graph = new ArrayList[N+1];
		for(int i =1; i<=N; i++) graph[i]= new ArrayList<>();
		
		familly = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N-1; i++){
			st = new StringTokenizer(br.readLine());
			//간선은 정점N 보다 1개 작다.
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//트리는 무방향= 양방향
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//트리 돌리기1
		dfs(R);
		
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < Q; i++) {
            //뽑아쓰기2
        	int x = Integer.parseInt(br.readLine());
            sb.append(familly[x]).append('\n');
        }
        System.out.print(sb);
	}
	
	//다 구해놓고1
	static void dfs(int cur) {
		visited[cur]= true;
		familly[cur] = 1;
		for(int next: graph[cur]) {
            if (!visited[next]) {
                dfs(next);
                familly[cur] += familly[next];
			}
		}
	}
}