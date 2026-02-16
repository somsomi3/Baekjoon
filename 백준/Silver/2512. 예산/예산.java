import java.io.*;
import java.util.*;

public class Main {
	static int N, chong;
	static int[] arr;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		
		arr = new int[N];
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
			max = Math.max(max, arr[i]);
		}
		Arrays.sort(arr);
		
		chong = Integer.parseInt(br.readLine());
		
		int ans = 0;
		if(chong>=sum) {
			System.out.println(max);
		}else {
			int left = 0;
			int right = arr[N-1];
			
			while(left<=right) {
				int mid = (left+right)/2;
				
				if(canMid(mid)<=chong) {
					ans = mid;
					left = mid+1;
				}else if(canMid(mid)>chong) {
					right = mid-1;
				}
			}
			System.out.println(ans);
		}
	}
	static int canMid(int target) {
		int summ = 0;
		for(int i =0; i<N; i++) {
			if(arr[i]<=target) {
				summ+= arr[i];
			}else {
				summ+=target;
			}
		}
		
		return summ;
	}
}
