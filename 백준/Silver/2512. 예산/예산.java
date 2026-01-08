import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum =0;
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+= arr[i];
		}
		M =Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);

		if(sum<=M)System.out.println(arr[N-1]);
		
		else {
			int left =0;
			int right = arr[N-1];
			int ans = 0;
			
			while(left<=right) {
				int mid = (left+right)/2;
				if (canMoney(mid) <= M){
					ans = mid;
					left = mid+1;
				}else {
					right = mid-1;
				}
			}System.out.println(ans);
		}
		
		
	}
	static int canMoney(int mid) {
		int canSum =0;
		for(int i=0; i<N; i++) {
			if(arr[i]<=mid)canSum+=arr[i];
			else canSum+=mid;
		}
		return canSum;
	}
}
