import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 누적합에서는 항상 1부터 입력 받자. 그래야 깔끔하다.
		//그래서 항상 배열을 정의할때는 [N+1]
		
		int[] arr = new int[N+1];
		int[] prefix= new int[N+1];//prefix: 압부분, 압부분의 합
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefix[i]= prefix[i-1]+arr[i];
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int x = prefix[r]-prefix[l-1];
			sb.append(x).append('\n');
//			System.out.println(x);
			
		}

		System.out.print(sb);
	}
}