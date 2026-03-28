import java.io.*;
import java.util.*;

public class Main {
	static int M, N; 
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr= new int[N];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
//		int left = 0;
		//과자를 조개서 나눠줄수도 있으므로
		int left = 1;
		
		//right = 최대 = 가장 긴 과자의 길이
		int right = max;
		int ans = 0;
		
		while(left <= right) {
			int mid = (left + right) /2;
			
			if(canCount(mid)>=M) {
				ans = mid;
				left = mid+1;
			}else {
				right = mid -1;
			}
			
		}
		System.out.println(ans);
		
	}
	static int canCount(int target) {
		int cnt = 0;
		for(int i = 0; i< N; i++) {
			if(arr[i]>=target)cnt += arr[i] / target;
		}
		return cnt;
	}
}