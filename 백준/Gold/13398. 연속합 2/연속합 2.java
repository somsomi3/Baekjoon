import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}	
		
        int[][] dp = new int[N + 1][2]; // 0: 제거 안 함, 1: 한 번 제거함
        dp[1][0] = arr[1];
        dp[1][1] = arr[1]; // 초기값 설정
        
        int max = arr[1];	
		
		for( int i=2; i<=N; i++) {
			dp[i][0]= Math.max(dp[i-1][0]+ arr[i], arr[i]);
			dp[i][1]= Math.max(dp[i-1][1]+ arr[i], dp[i-1][0]);
			
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}

        System.out.println(max);
	}
}

