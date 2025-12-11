import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		
		int a =0;
		int b = 0;
		if(A%C==0)a = A/C;
		else a= A/C+1;
		if(B%D==0)b = B/D;
		else b= B/D+1;
		
		int x = Math.min(L-a, L-b);
		System.out.println(x);
	}
}