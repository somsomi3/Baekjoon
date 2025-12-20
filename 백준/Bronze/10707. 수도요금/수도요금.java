import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		int xA = P*A;
		
		int xB = 0;
		if(P>C) {
			xB = B+(P-C)*D;
		}else {
			xB = B;
		}
		int answer = Math.min(xA, xB);
		System.out.print(answer);
	}
}
