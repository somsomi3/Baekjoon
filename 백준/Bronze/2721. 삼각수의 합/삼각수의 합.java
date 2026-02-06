import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int sum =0;
			for(int i =1; i<=N; i++) {
				sum+= i*T(i+1);
			}
			System.out.println(sum);
		}
		
	}
	static int T(int x) {
		int ssum =0;
		for(int i =1; i<=x; i++) {
			ssum+=i;
		}
		return ssum;
	}
}
