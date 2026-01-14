import java.io.*;
import java.util.*;

public class Main {
	
	static int[] arr;
	static int N, M;
	static int sum=0;
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i =0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		int max = 0;
		//최솟값주의 
		for (int x : arr) max = Math.max(max, x);
		int left = max;
		int right = sum;
		
		int ans =1_000_000_001;
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(canCount(mid)<=M) {
				right= mid-1;
				ans = Math.min(mid,ans);
			}else left =mid+1;
		}
		
		System.out.println(ans);
	}
	static int canCount(int mid) {
		int count =1; 
		int a = mid;
		for(int i=0; i<N; i++) {
			if(arr[i]<=a) {
				a-= arr[i];
			}else if(arr[i]>a) {
				count++;
			    a = mid - arr[i];
			}
		}
		return count;
	}
}