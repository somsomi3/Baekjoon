import java.io.*;
import java.util.*;

public class Main {
	static int N, M; 
	static int[] arr;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int max = 0;
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		
		int left = max;
//		int right = 10000;
		int right = 0;
		for(int i = 0; i < N; i++) {
		    right += arr[i];
		}
		int ans = 0;
		while(left<= right) {
			int mid = (left + right) /2;
			
			if(canSpend(mid)<=M) {
				ans = mid;
				right = mid -1;
			}else {
				left = mid +1;
			}
		}
		System.out.println(ans);
		
	}
	static int canSpend(int target) {
		
		int x = target;
		int cnt = 1;
		for(int i = 0; i<N; i++) {
			if(x >= arr[i]) {
				x -= arr[i];
			}else {
                cnt++;
                x = target - arr[i];
			}
				
		}
		return cnt;
	}
}