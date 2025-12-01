import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = 3;
		int M = 2;
		 
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]= Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int[] brr = new int[M];
		for(int j =0; j<M; j++) {
			brr[j] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(brr);

		System.out.println(arr[0]+brr[0]-50);
		
	}
}
