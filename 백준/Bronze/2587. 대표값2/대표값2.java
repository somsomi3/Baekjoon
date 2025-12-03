import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 5; 
		int[] arr = new int[N];
		
		int sum = 0;
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		//1. 평균
		System.out.println(sum/5);
		
		//2. 중앙값: 정렬하고 순서/2+1한거 택
		Arrays.sort(arr);

		System.out.println(arr[2]);

	}
}
