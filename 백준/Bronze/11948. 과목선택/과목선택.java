import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//배열의 크기중요, 초기 배열의 값들은 모두 0
		int[] arr = new int[4];
		for(int i =0; i<4; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
//		for(int i =0; i<4; i++) {
//			System.out.println("기본"+arr[i]);
//		}
		Arrays.sort(arr);
//		for(int i =0; i<4; i++) {
//			System.out.println("정렬후"+arr[i]);
//		}
		int[] brr = new int[2];
		for(int i =0; i<2; i++) {
			brr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		Arrays.sort(brr);		

		int sum=0;
		
		for(int i =1; i<4; i++) {
			sum+= arr[i];
		}
		sum+=brr[1];
		
		System.out.println(sum);
	}
}