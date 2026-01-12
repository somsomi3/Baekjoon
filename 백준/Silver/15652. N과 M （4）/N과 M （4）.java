import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr= new int[M];
		//1부터 시작되는 숫자들
		visited = new boolean[N+1];
		dfs(0,1);
        System.out.print(sb);
	}
	static void dfs(int depth, int start) {
		if(depth==M) {
            for (int i = 0; i < M; i++) {
//            	if(arr[i]<arr[i+1]) {
            	sb.append(arr[i]+1).append(" ");	
            	
               //else continue;  //=> 없어도 되려나...
            }
            sb.append("\n");
            return;
		}
        for (int i = start-1; i < N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
	}
}
