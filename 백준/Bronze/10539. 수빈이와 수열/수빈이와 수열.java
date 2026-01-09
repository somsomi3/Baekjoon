import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int ans =0;
		int sum =0;
		for(int i=1; i<=N; i++) {
			
			int B = Integer.parseInt(st.nextToken());
			
			if(i==1) {
				ans=B/i;
				sum+= ans;
				sb.append(ans);
			}
			else{
				ans = (i*B)-sum;
				sum+= ans;
				sb.append(" "+ans);
			}

		}
		System.out.println(sb);
		
	}
}