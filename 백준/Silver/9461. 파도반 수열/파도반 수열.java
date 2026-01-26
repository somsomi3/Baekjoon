import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
            if (N <= 3) {
                System.out.println(1);
                continue;
            }

            long[] dp = new long[N + 1];
			
			dp[1] =1;
			dp[2]= 1;
			dp[3]= 1;
			
			for(int i =4; i<= N; i++) {
				dp[i]= dp[i-3]+dp[i-2]; 
			}
			
			System.out.println(dp[N]);
		}
		
	}
}