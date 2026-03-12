import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		visited = new boolean[N+1];
		dfs(1, 0);//시작과 depth시작
		
        System.out.print(sb);
	}
	static void dfs(int start, int depth) {
		
		if(depth==M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i<= N; i++) {
			if(!visited[i]) {
				arr[depth] =i;
				visited[i] = true;
				dfs(start+1, depth+1);
				visited[i] = false;
			}

		}	
	}
}
