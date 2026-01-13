import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); 
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			
			int left = 0;
			int right = N;
			//끝점을 N으로 두는 이유는
//			“정답이 N이 될 수도 있기 때문”
			
			while(left<right) {
				int mid = (left+right)/2;
				
				if(arr[mid]<start) {
					left= mid+1;
				}else right =mid;
			}
			int lower = left;
			
			//초기화 빼먹지 말자.
			left = 0;
			right = N;
			
			while(left<right) {
				int mid = (left+right)/2;
				
				if(arr[mid]<=end) {
					left= mid+1;
				}else right=mid;				
			}
			int upper = left;

            sb.append(upper - lower).append(" ");
			
		}
		
        System.out.println(sb);
	}
}