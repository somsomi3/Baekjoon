import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		Arrays.sort(arr);
//		System.out.println(arr[0]+ " " + arr[N-1]);
		
		int big = -1_000_001;
		int small = 1_000_001;
		for(int i =0; i<N; i++) {
			if(big<arr[i]) {
				big = arr[i];
//				System.out.println(big);
//			}else if(small>arr[i]) {
			}if(small>arr[i]) {
				small = arr[i];
			}
		}
		System.out.println(small+" "+big);
	}
}
