import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int max = -1_000_001;
			int min = 1_000_001;
			
			for(int i =0; i<N; i++) {
				int x = Integer.parseInt(st.nextToken());
				max = Math.max(max, x);
				min = Math.min(min, x);
			}
			
			sb.append(min).append(" ").append(max).append("\n");
		}
		System.out.println(sb);	
	}
}	
