import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int g = gcd(a, b);
			int l = (a*b)/g;
			System.out.println(l);
		}
	}
	
	static int gcd(int x, int y) {
		while(y>0) {
			int r = x % y;
			x = y;
			y = r;
		}
		return x;
	}
}
