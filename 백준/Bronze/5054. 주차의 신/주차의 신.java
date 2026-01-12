import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			Arrays.sort(arr);
			int sum =0;
			for(int i =0; i<N-1; i++) {
				int x = arr[i+1] -arr[i];
				sum+=x;
			}
			
			System.out.println(sum*2);
		}
		
	}

}
