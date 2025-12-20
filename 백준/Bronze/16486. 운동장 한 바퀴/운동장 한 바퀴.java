import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());
//		3.141592
//		Math.PI
		double x = 2 * d1 + 2 * 3.141592 * d2;
		
//		System.out.printf(%d% \n %6.f%, x);
		System.out.printf("%.6f", x);
	}
}
