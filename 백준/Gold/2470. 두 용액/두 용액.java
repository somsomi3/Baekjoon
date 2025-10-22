import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int l =0;
		int r = N - 1;

		int ml =0;
		int mr =0;
		int bestSum = Integer.MAX_VALUE; 
		
		int S =0 ;// 목표 합...
		
		while (l < r) {
			int sum = arr[l] + arr[r];
			
			if(Math.abs(sum)<Math.abs(bestSum)) {
				bestSum = sum;
				ml = l;
				mr =r;
			}
			if (sum > 0) r--;   // 합이 양수면 줄이기
		    else l++;            // 합이 음수면 키우기
		}	
		System.out.print(arr[ml] +" "+ arr[mr]);
	}
}