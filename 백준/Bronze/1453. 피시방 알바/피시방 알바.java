import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[101];
		int count  =0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			int x  = Integer.parseInt(st.nextToken());
			if(arr[x]==0) {
				arr[x]++;
			}
			else {
				count++;
			}
		}
		System.out.println(count);

	}
}
