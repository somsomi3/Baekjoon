

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 연결 수
		
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i =0; i<m; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	graph[a].add(b);//양방향
        	graph[b].add(a);
        }
        dfs(1);
        System.out.println(count - 1); // 1번 컴퓨터 제외
	}
	static void dfs(int i) {
		visited[i]= true;
		count++;
        for (int next : graph[i]) {
        	if(!visited[next]) {
        		dfs(next);
		}
        }
	}
}
