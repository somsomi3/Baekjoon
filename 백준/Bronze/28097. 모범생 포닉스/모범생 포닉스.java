import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			sum+= Integer.parseInt(st.nextToken());
		}
		
		sum+= 8*(N-1);
//		StringBuilder sb = new StringBuilder();
		
		System.out.println(sum/24+" "+sum%24);
		
	}
}
