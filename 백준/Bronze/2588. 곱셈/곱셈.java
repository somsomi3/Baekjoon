import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int M= Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int a = N%10*M;
		N= N/10;
		int b = N%10*M;
		N /= 10;
		int c = N%10*M;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a+10*b+100*c);
	}
}
