import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int ans =0;
			for(int i=0; i<N; i++) {
				if(i*i+i<=N) ans =i;
				else break;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		
	}
}
