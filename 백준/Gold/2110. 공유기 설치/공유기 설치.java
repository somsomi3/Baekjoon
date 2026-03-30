import java.io.*;
import java.util.*;

public class Main {
	static int N, C;
	static int[] arr;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//정렬해라
		Arrays.sort(arr);
		int left = 1;
		int right = arr[N-1]- arr[0];//최대 사이간격은 처음 좌표와 마지막 좌표의 간격이다.
		
		int ans = 0;
		
		while(left <= right) {
			//사이간격이라는 mid값을 찾는 문제이다.
			int mid = (left+ right)/2;
			
			if(canInstall(mid)>= C) {
				ans = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}
		System.out.println(ans);
		
	}
	static int canInstall(int target) {
		int start = arr[0];
		int cnt = 1;
		
		for(int i = 1; i<N; i++) {
			if(arr[i]-start>= target) {
				cnt++;
				// 설치 햇을때만 갱신해야함.
				start = arr[i];
			}
		}
		return cnt;
	}
}	
