import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr= new int[N];
		int[] dp = new int[N];

		
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0]= 1;
		int max = 1;
		
		for (int i = 0; i < N; i++) {
		    dp[i] = 1;
		    for (int j = 0; j < i; j++) {
		        if (arr[j] < arr[i]) {// 여기가 핵심. 이중 for문 생각은 햇음.
		            dp[i] = Math.max(dp[i], dp[j] + 1);
		        }
		    }
		}

		
		for(int i=0; i<N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}