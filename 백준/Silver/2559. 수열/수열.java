import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum =0;
		//초기 배열
		for(int i=0; i<K; i++) {
			sum+=arr[i];
		}
		int maxSum = sum;
		
		int l =0;
		int r =K;
//		while(l<r) {
		while (r < N) {
//			sum-=arr[l]+=arr[r];
			sum = sum - arr[l] + arr[r];
			l++;
			r++;
			maxSum = Math.max(maxSum, sum);
		}
		System.out.println(maxSum);
	}
}
