import java.io.*;
import java.util.*;

public class Main {
	static int N, M; 
	static int[] arr;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
	
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int l = findLeft(x);
			int r = findRight(y);
			
			int ans = r-l;
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static int findLeft(int target) {
	    int left = 0;
	    int right = N; // N까지

	    while (left < right) {
	        int mid = (left + right) / 2;

	        if (arr[mid] >= target) {
	            right = mid;
	        } else {
	            left = mid + 1;
	        }
	    }
	    return left;
	}
	static int findRight(int target) {
	    int left = 0;
	    int right = N;

	    while (left < right) {
	        int mid = (left + right) / 2;

	        if (arr[mid] > target) {
	            right = mid;//mid가 정답일 수도 있음.그래서 mid-1이 아니라 mid.
	        } else {
	            left = mid + 1;
	        }
	    }
	    return left;
	}
}