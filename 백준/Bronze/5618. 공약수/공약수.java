
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] count = new int[arr[0]+1];
		
		for(int x : arr) {
			int max =0;
			 for(int i =1; i<=arr[0]; i++) {
				 if(x%i==0) {
					 count[i]++;
				 }
			 }
		}
		for(int i =1; i<=arr[0]; i++) {
			if(count[i]==N) {
				System.out.println(i);
			}
		}
	}
	
}
