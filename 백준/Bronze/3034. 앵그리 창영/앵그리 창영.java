import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
//		int x = Math.max(W, H);
		int dakaksun = W*W + H*H;
		
		for(int i= 0; i<N;i++) {
			int a = Integer.parseInt(br.readLine());
			
		    if (a*a <= dakaksun) System.out.println("DA");
			else System.out.println("NE");
		}
	}
}
//a ≤ √(W² + H²)
//⇔ a² ≤ W² + H²
