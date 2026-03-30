import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		int[] health = new int[N+1];
		for(int i = 1; i <= N; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] happy = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			happy[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N + 1][100 + 1];
		
        for (int i = 1; i <= N; i++) {
            for (int ha = 0; ha <= 100; ha++) {


                // 1. 인사안해
                dp[i][ha] = dp[i - 1][ha];

                // 2. 인사 해
                if (ha-health[i] >0) {//조건
                    dp[i][ha] = Math.max(
                        dp[i][ha],
                        dp[i - 1][ha - health[i]] + happy[i]
                    );
                }
            }
        }

        System.out.println(dp[N][100]);
    }
}