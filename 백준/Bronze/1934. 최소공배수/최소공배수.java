import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			
			int g = gcd(a, b);
			int l = a*b/g;// g최대공약수는 1이 제일 작다.그래서 0으로 나누기걱정은 안해도될듯하다.
			
			System.out.println(l);
		}
		
	}
	static int gcd(int a, int b) {
		while(b>0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	
}
