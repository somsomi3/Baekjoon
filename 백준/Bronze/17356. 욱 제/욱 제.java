import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		double x = (double) (B-A)/400;
//		System.out.println(x);
		
		double y = (double)1/(1+Math.pow(10, x));
		
		System.out.println(y);
	}
}
