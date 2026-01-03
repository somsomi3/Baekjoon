import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StirngTokenizer st = 
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		//위에 다 적어놧긴 한데ㅔ... dp[1] 이랑 dp[2]는 수작업으로 적어야하려나..
		
		if(N==1) {
			System.out.println(arr[0]);
		    return;
		}
		else if(N==2) {
			System.out.println(arr[0]+arr[1]);
		    return;
		}
		
		dp[0] = arr[0];
		dp[1] = arr[0] + arr[1];
		dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2])
		);
		
		//dp[i] = 0번 잔부터 i번 잔까지 고려했을 때, 마실 수 있는 최대 포도주 양
		for(int i =3; i<N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]));
		}
		
//		int max =  0;
//		for(int i=0; i<N; i++) {
//			max = Math.max(max, dp[i]);
//		}
//		System.out.println(max);
		
        System.out.println(dp[N-1]);
	}
}