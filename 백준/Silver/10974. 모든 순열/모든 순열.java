import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        arr = new int[N];

        dfs(0);

        System.out.print(sb);
    }
	
	static void dfs(int x) {
		 if (x == N) {
	            for (int i = 0; i < N; i++) {
	                sb.append(arr[i]).append(" ");
	            }
	            sb.append("\n");
		        return;
		    }
		
		for( int i = 1 ; i <= N ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[x] = i;
				
				dfs(x+1);
				visited[i] = false;
			}
		}
	}
}
