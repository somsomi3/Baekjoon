import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(arr);
		
		int left = 0;//인덱스다.
		int right = N-1;
		int cnt = 0;
		int sum = 0;
		
		while(left<right) {
			//한가지 값을 left와 right로 두번 사용할 수 는 없다.
			
			sum = arr[left] + arr[right];//매번 더해봐야한다.
			
			if(sum==M) {
				cnt++;
				left++;
				right--;
			}else if(sum> M) {
				right--;
			}else {
				left++;
			}
			
		}
		System.out.println(cnt);
	}
}