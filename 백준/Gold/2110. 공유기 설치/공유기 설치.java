import java.io.*;
import java.util.*;

public class Main {
	static int N , C;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N]; 
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		
//		int left = arr[0];
//		int right= arr[N-1];
        int left = 1; // 최소 거리
        int right = arr[N - 1] - arr[0]; // 최대 거리
		int ans = 0;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(canInstall(mid)>=C) {
				ans = mid;
				left = mid +1;
			}else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static int canInstall(int target) {
		int start = arr[0];
		int cnt = 1;
		
		for(int i = 0; i<N; i++) {
			if (start+target<=arr[i]) {
				cnt++;
				start = arr[i];
			}
		}
		
		return cnt;
	}
}
