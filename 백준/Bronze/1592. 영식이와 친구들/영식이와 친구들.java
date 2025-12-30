import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		int L= Integer.parseInt(st.nextToken());
		
		int g = gcd(N, L);
		
		int x = N*(M-1)/g;
		System.out.println(x);
		
	}
	
	static int gcd(int n, int l) {
		while(l>0) {
			int r = n%l;
			n = l;
			l= r;
		}
		return n;
	}
}
