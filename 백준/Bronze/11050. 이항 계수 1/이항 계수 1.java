import java.io.*;
import java.util.*;

public class Main {
	static int fact(int x) {
		int one =1;
		for(int i=1; i<=x; i++) {
			one*=i;
		}
		return one;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int ans = fact(N)/ (fact(N-K)*fact(K));
		System.out.println(ans);
		
	}
}
