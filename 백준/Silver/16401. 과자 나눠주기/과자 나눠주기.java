import java.io.*;
import java.util.*;

public class Main {
	static int right, N, M;
	static int[] arr;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());//줄내에서 띄어쓰기
		int right = 0;
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}
		
		int left =1;
		int ans =0;

		while(left<= right) {
			int mid = (left+right)/2;
			if(bigbig(mid)) {
				ans = mid;
				left = mid+1;
				
			}else {
				right =mid-1;
			}
		}
        System.out.println(ans);
	}

	static boolean bigbig(int stick) {
        if (stick == 0) return true; // 방어코드
        int count = 0;
        for (int snack : arr) count += snack / stick;
        return count >= M;
	}
}