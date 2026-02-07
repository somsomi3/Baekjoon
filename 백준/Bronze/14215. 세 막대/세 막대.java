import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = 3;
		
		int[] arr = new int[T];
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sum =0;
		for(int i=0; i<=arr[0]; i++) {
			for(int j =i; j<=arr[1]; j++) {
				for(int k=i; k<=arr[2]; k++) {
					if(i+j>k) {
						int x= i+j+k;
						if(x>sum)sum=x;
					}	
				}
			}
		}
		System.out.println(sum);
	}
}
