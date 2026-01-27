import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int sum =0;
			st = new StringTokenizer(br.readLine());
			for(int i =0; i<N; i++) {
				int a = Integer.parseInt(st.nextToken());
				
				int x = a/K;
				sum+= x;
			}
			
			System.out.println(sum);
		}

	}
}
