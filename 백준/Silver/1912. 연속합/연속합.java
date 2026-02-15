import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		int max = -1001;
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			int x = Integer.parseInt(st.nextToken());
			sum = Math.max(x, sum + x);
		    max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}