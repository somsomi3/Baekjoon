import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int l= 0; 
		int r = l+K;
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//초기값
		int x = 0;
		for(int i=l; i<r; i++) {
			x+= arr[i];
		}
		int max = x;
		while(r<N) {
			x = x-arr[l]+arr[r];
			max = Math.max(max, x);
			l++;
			r++;
		}
		System.out.println(max);
	}
}
