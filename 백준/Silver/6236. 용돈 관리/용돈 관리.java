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
		
		int max = 0;
		arr= new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		int left = max;
		int right = max*N;
		int ans = 0;
		
		while(left<= right) {
			int mid = (left+right)/2;
			
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
		int cnt = 1;
		
		int x = target;
		for(int i = 0; i<N; i++) {
			if(arr[i]<=x) {
				x -= arr[i];
			}else {
				cnt++;
				x = target- arr[i];
			}
		}
		return cnt;
	}
}
