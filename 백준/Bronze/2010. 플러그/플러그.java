import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int sum =0;
		for(int i =0; i<N-1; i++) {
			sum+=(Integer.parseInt(br.readLine())-1);
		}
		sum+= Integer.parseInt(br.readLine());
		System.out.println(sum);
	}
}
