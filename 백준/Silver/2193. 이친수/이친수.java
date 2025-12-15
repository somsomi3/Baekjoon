import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		N = 1 일 때 배열 범위 초과
//		if (N == 1) {
//		    System.out.println(1);
//		    return;
//		}
		
		long[] dp = new long[N+1];
		
		dp[1] =1;
		//N은 1일때 dp[2]는 없다.
		if (N >= 2) dp[2] = 1;
		
		for(int i =3; i<=N; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[N]);
	}
}
