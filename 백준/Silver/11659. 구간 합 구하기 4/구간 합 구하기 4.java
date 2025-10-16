import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
	    for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] prefix = new int[N+1];
		//누적합
		for(int i =1; i<=N; i++) {
			prefix[i] = prefix[i-1]+arr[i];
		}

		StringBuilder sb = new StringBuilder();
		
		
		for( int j =0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			sb.append(prefix[r]-prefix[l-1]).append('\n');
			
		}
		System.out.print(sb);
	}
}
