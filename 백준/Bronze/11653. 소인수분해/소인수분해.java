import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =2; i*i<=N; i++) {
//			if(N%i==0)
////			for(int j =i*i; j<=N; j+=i) {
//				System.out.println(i);
//				N= N/i;
			  while (N % i == 0) {
	                System.out.println(i);
	                N /= i;
	            }
	        }

	        if (N != 1) System.out.println(N);
	    }
	}