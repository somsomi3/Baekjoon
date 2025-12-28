import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];

		for(int i =0; i<N; i++) {
            //초기화
		    dp[i] = arr[i];
			for(int j =0; j<i; j++) {
				if(arr[j]<arr[i])dp[i] = Math.max(dp[i], dp[j]+arr[i]);
			}
		}
		int ans =0;
		for(int x: dp) {
			ans = Math.max(ans,x);
		}
		System.out.println(ans);
	}
}
