import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A= Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long g = gcd(A, B);
		long ans = A*B/g;
		
		System.out.println(ans);
	}
	
	static long gcd(long A, long B) {
		while(B>0) {
			long r = A%B;
			A = B;
			B = r;			
		}
		return A;
	}
}
