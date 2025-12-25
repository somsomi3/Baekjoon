import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
            int g = gcd(a, b);
            int l = a / g * b;// 범위 초과 주의를 위해, 먼저 나누고 곱해줌
            System.out.println(l+" "+g);
			
		}
	
	}
	static int gcd(int a, int b) {
		while(b>0) {
			int r = a%b;
			a =b;
			b= r;
		}
	    return a;
	}
}
