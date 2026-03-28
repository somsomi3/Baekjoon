import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long g = gcd(a, b);
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < g; i++) {
		    sb.append('1');
		}

		System.out.println(sb);
	}
	
	static long gcd(long a, long b) {
		
		while(b >0) {
			long temp = a % b;
			a = b;
			b = temp;
			
		}
		return a;
	}
}
