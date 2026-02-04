import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//int sum =0;
		long sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sum +=Math.abs(arr[i]-arr[j]);
			}
		}
		System.out.println(sum);
	}
}
