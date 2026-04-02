import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr= new int[N];
		int max = 0;
		int sum =0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
		
		int left = max;
		int right = sum;
		int ans = 0;
		while(left<= right) {
			int mid = (left+ right)/2;
			
			if (canMake(mid) <= M) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
			
		}
		
		System.out.println(ans);
	}
	static int canMake(int target) {
		int s = 0;
		int xx = 0;
		int cnt = 1;
		for(int i = 0; i<N; i++) {
			s+= arr[i];
			xx= arr[i];
			
			if(s>target) {
				cnt++;
				s = arr[i];
			}
        }
		return cnt;
	}
}
