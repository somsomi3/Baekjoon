import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A= Long.parseLong(st.nextToken());
		long B= Long.parseLong(st.nextToken());
		
		long n = Math.abs(B-A)+1;
		long sum =(A+B)*n/2;
		
		System.out.println(sum);
	}
}