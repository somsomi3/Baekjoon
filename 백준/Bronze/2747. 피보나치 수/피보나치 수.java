import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		//다 더하면,,? 초과안나려나.. 일단 이렇게 해도 지금은 45까지 합이라 괜찮은데,., 다른 최적화 방법은?
		
		int[] dp = new int[N+1];
		
		dp[0] =0;
		dp[1]=1;
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-2] +dp[i-1];
		}
		
		System.out.println(dp[N]);
	}
}