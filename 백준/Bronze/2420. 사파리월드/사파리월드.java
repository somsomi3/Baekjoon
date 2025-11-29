import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//N, M의 범위(-2,000,000,000 ≤ N, M ≤ 2,000,000,000)
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		
		long ans = Math.abs(N-M);
		
		System.out.println(ans);
		
	}
}
