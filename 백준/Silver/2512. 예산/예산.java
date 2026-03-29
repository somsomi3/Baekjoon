import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr= new int[N];
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		//배열 안에서 값을 찾는게 아니라서, 정렬할 필요없음.
		
		M = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = max;
		int ans = 0;
		while(left <= right) {
			int mid = left +(right - left) /2;
			
			if(canSum(mid)<=M) {
				ans = mid;
				left = mid+1;
			}else {
				right = mid -1;
			}
		}
		System.out.println(ans);
		
	}
	static int canSum(int target) {
		int sum = 0;
		
		for(int i = 0; i< N; i++) {
			if(arr[i]<target) {
				sum+= arr[i];
			}else {
				sum+= target;
			}
		}
		
		return sum;
	}
}
