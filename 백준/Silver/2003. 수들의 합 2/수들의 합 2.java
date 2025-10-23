import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] prefix = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i =1; i<=N; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			prefix[i] = prefix[i-1]+arr[i];
			
		}
		
		int left = 1;
		int right = 1;
//		int sum =0;
		
		int count =0;
		
//		while(left<right) {
		while(right <= N) {
			
			int sum = prefix[right] - prefix[left - 1];
			
			if(sum<M)right++;
//			else if(sum==M)count++;
//			else left++;
			else {
				if(sum==M)count++;
				left++;
			}
	
		}
		System.out.print(count);	
	}
}