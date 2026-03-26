import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		int max = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		//인덱스 가 아니고 값이다!
		int left = 0;//0으로 나누기 에러가 날 확률은?
		int right = max;
		int ans = 0;
		while(left<=right) {
			int mid = (left + right)/2;
			
			if(canSpend(mid) <= M) {

				ans = mid;// 굳이 math.max를 안써도 자동으로 max값이 들어갈껄..? left가 점점 증가하니까.
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		
		System.out.println(ans);
	}
    static int canSpend(int target) {
        int sum = 0;
		for(int i = 0; i< N; i++) {
			if(arr[i]>= target) {
				sum+= target;
			}else {
				sum += arr[i];
			}
		}
		return sum;
	}
}