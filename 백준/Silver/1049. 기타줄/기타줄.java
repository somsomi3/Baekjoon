import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int ans = 100001;
		int xAns = 100001;
		int yAns = 100001;
		int allAns = 0; 
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());//6개입.
			int b = Integer.parseInt(st.nextToken());
			
			if(N<=6) {
				int x = Math.min(a, b*N);
				ans = Math.min(ans, x);
			}else {
				int xSum = Math.min(a*(N/6), b*6*(N/6));
				xAns = Math.min(xAns, xSum); 
				int ySum = Math.min(a, b*(N%6));
				yAns = Math.min(yAns, ySum); 
				ans = xAns+ yAns;
			}
			

		}
		
		System.out.println(ans);
	}
}
