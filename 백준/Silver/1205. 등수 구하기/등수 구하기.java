import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if(N == 0) {
			System.out.println(1);
			return;
		}
		
//		String[] arr = br.readLine().split(" ");
//		int[] brr = new int[N];
//		
//		for(int i = 0; i < N; i++) {
//			brr[i] = Integer.parseInt(arr[i]);
//		}
		
		int[] brr = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i =0; i<N; i++) {
			brr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int cnt = 1;
		for(int i = 0; i < N; i++) {
			if(brr[i] > x) cnt++;
		}
		
		// 랭킹이 꽉 찼고, 마지막 점수보다 작거나 같으면 못 들어감
		if(N == P && brr[N-1] >= x) {//cnt는 등수, N이 자릿값이므로, 고정값인 N과 P를 비교해라.
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}
}