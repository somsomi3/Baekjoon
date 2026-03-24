import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		
		int[] brr = new int[M];
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
			
		}
		for(int i = 0; i< M; i++) {
			//인덱스값
			boolean flag = false;
			int left = 0;
			int right = N-1;
			
//			while(left<right) {
		    while(left <= right) {
				int mid = (left+right)/2;
				if(arr[mid]==brr[i]) {
					flag = true;
					break;
				}else if(arr[mid]>brr[i]) {
					right = mid-1;
				}else {
					left = mid+1;
				}
			}
			if(flag)sb.append(1).append('\n');
			else sb.append(0).append('\n');
			
		}
		System.out.println(sb);	
	}
}