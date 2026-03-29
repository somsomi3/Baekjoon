import java.io.*;
import java.util.*;

public class Main {
	static int N, M; 
	static int[] arr;
	static int[] brr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		M = Integer.parseInt(br.readLine());
		
		brr= new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			brr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i< M; i++) {
			
			//인덱스
			int left = 0;
			int right = N-1;
			
			boolean flag = false;
			while(left<= right) {
				int mid = left + (right - left)/2;
				
				if(arr[mid]== brr[i]) {
					flag = true;
					break;
				}else if(arr[mid]> brr[i]) {
					right = mid -1;
				}else {
					left = mid +1;
				}
			}
			
			if(flag)sb.append("1").append(" ");
			else sb.append("0").append(" ");
		}
		System.out.println(sb);
	}
}