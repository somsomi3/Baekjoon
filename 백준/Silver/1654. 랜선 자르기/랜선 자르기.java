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
		for(int i = 0; i <N; i++) {//long으로 입력 받아야 하나? 2의 32승은 얼마지?
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
        long left = 1;
        long right = max;
        long ans = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
			
			if(canCut(mid)>= M) {
				ans = mid;
				left = mid+1;
			}else {
				right = mid -1;
			}
		}
		System.out.println(ans);
		
	}
    static long canCut(long target) {
        long sum = 0;
		for(int i = 0; i<N; i++) {
            sum += arr[i]/ target;
        }
		return sum;
	}
}