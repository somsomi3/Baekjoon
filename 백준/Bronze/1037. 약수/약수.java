import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr);
		
		int min = 1000001;
		int max = 1;
		for(int i = 0; i<N; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		long ans = min*max;
		
		System.out.println(ans); 
		
	}
}
