import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
//		int right = 1;
		int right = 0;
		int sum = arr[0];
	
		int count =0;
//		while(right<N) { //=>left 이동부분이 애매해짐.
		while (true) {	
//			sum= arr[left]+arr[right];
			
			//양수 배열에선 left를 줄이는 게 정석
			if(sum>M) {
				sum-=arr[left];
				left++;
				
			}else if(sum<M) { //맨처음 경우가 여기라서, right부터 시작해도 중복수는 없음.
				right++;
		        if (right == N) break;
				sum+=arr[right];
				
			}else {
				//0에서 시작해서 오른쪽으로 나아가고 잇으니, 왼쪽을 먼저 빼서 변화를 주자.
				count++;
		        sum -= arr[left];
				left++;
//				right++;
			}
			
		}
		System.out.println(count);
	}
}