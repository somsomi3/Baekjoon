import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int x =0;
		if(A<0) {
			x = -A*C+D+B*E;
		}else if(A==0) {
			x = D+B*E;
		}else if(A>0) {
			x = (B-A)*E;
		}
		System.out.println(x);
	}
}
