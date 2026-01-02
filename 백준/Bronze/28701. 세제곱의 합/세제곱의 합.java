import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		
		int sum = 0;
		for(int i =1; i<=N; i++) {
			sum+=i;
		}
		
		int ze = sum*sum;
				
		int sam = 0;
		for(int i =1; i<=N; i++) {
			sam+=i*i*i;
		}
		System.out.println(sum);
		System.out.println(ze);
		System.out.println(sam);
		
	}
}
