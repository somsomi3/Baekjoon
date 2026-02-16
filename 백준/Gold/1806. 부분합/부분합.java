import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
        int min = Integer.MAX_VALUE;
		int sum =0;
		//만약 맨처음 값이.. S보다 크다면...
		//sum이 0이라서 맨처음에는 항상 확장 부분으로 가. 그래서 left랑 right가 뒤집힐 위험은 없음.
		boolean flag = false;
//		while(right<N) {
		//right가 N이 되면 left를 더 줄여서 길이 갱신이 가능하다.
		while (true) {
		    if (sum >= S) {
		    	flag = true;
				min= Math.min(min, right - left);
				sum -= arr[left];
				left++;	
			}
		    else if (right == N) {
		        break;
		    } 
			else {
				sum+=arr[right]; 
				right++;
			}
		}
		if(!flag)System.out.println(0);
		else System.out.println(min);
	
	}
}