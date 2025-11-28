import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = 5;
		
		int sum = 0;
		for(int i =0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x<40)x=40;
			sum +=x;
		}
		System.out.println(sum/5);
	}
}
