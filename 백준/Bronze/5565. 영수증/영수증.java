import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = Integer.parseInt(br.readLine());
		
		int N = 9;
		
		for(int i =0; i<N; i++) {
			sum-= Integer.parseInt(br.readLine());
		}
		System.out.println(sum);
	}
}
