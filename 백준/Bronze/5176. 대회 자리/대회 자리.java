import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int P = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean[] cnt = new boolean[M+1];
			
			int ans =0;
			for(int i=0; i<P; i++) {
				int x = Integer.parseInt(br.readLine());
				if(!cnt[x]) {
					cnt[x]= true;
				}else {
					ans++;
				}
			}
			System.out.println(ans);
		}	
	}
}
