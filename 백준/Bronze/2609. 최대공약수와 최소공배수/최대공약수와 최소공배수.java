import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int g = gcd(N, M);
		int l = N*(M/g);
		
		sb.append(g+"\n").append(l);
		System.out.println(sb);
	}
	static int gcd(int x, int y) {
		while(y>0) {
			int r = x%y;
			x = y;
			y = r;
		}
		return x;
	}
	
}
