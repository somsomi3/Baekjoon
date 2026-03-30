import java.io.*;
import java.util.*;

public class Main {
	static int K, N;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr= new int[K];
		
		int max = 0;
		for(int i = 0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		//정렬 필요없음. 배열안의 값을 보는 것이 아님.
		long left = 1;
		long right = max;
		
		long ans = 0;
		
		while(left<=right) {
			//값을 찾는다. 
			long mid = (left+right)/2;
			
			if(canCut(mid)>= N) {
				ans = mid;
				left = mid+1;
			}else {
				right = mid -1;
			}
			
		}
		System.out.println(ans);
		
		
	}
	static long canCut(long target) {
		long sum = 0;
		
		for(int i = 0; i<K; i++) {
			if(arr[i]>=target) {
				sum += arr[i]/target;
			}
		}
		return sum;
	}
}
