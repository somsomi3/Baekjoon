import java.io.*;
import java.util.*;
	
public class Main {
	static int[] arr;
	static int[] srr;
	static boolean[] visited;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//중복허용안됨
		visited = new boolean[N+1];
		
		srr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			srr[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(srr);
		
		arr= new int[M];
		//1부터 시작되는 숫자들
		visited = new boolean[N+1];
		dfs(0);
        System.out.print(sb);
	}
	static void dfs(int depth) {
		if(depth==M) {
            for (int i = 0; i < M; i++) {	
            	sb.append(arr[i]).append(" ");	
            }
            sb.append("\n");
            return;
		}
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
        	visited[i]= true;
            arr[depth] = srr[i];
            dfs(depth + 1);
            visited[i]= false;
        }
	}
}
