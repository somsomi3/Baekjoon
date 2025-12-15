import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];

		for(int i = 0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		//dp[K]는 가치의 합을 나타낸다
		int[] dp = new int[K+1];// 항상 dp문제에서 dp배열의 범위는 주어지는 합+1까지의 범위인듯하다
//		ex)앞에 나왔던 1로만들기? 문제 같은경우. -하게 되면 N이하의 범위라는... 등.
		dp[0] = 1;	
//		i == c 일 때,	즉 dp[c] += dp[0]
		for(int c: coin) {
			for(int i=c; i<=K; i++) {
				dp[i]+= dp[i-c];// 순열이 되지않게 12 와 21은 같은 것으로 보기에 윗줄에서 c부터 시작해서
				//그 이전의 것을 자동으로 제외 시켜 조합을 구한다.
//				i == c 일 때,	즉 dp[c] += dp[0]
				
			}
		}
		System.out.println(dp[K]);
	}
}