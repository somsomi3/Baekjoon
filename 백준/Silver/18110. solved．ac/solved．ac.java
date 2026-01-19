import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
//		double x = N/100*15; => N / 100  나머지 다 날려버림.
		double x = N * 0.15;
		
		int ze = (int) Math.round(x);
		
		int [] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int sum =0;
		int count =0;
		for(int i=ze; i<N-ze; i++) {
			sum+= arr[i];
			count++;
		}
//		System.out.println(Math.round(sum / count));=> 이건 int 
		System.out.println(Math.round((double) sum/count));
	}
}
