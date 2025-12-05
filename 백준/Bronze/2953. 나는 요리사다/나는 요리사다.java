import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 5;
		int max =0;
		int ii =0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for(int j=0; j<4; j++) {
				int x = Integer.parseInt(st.nextToken());
				sum += x;
			}
			if(sum>max) {
				max =sum;
				ii =i+1;
			}
			
		}
		System.out.println(ii+" "+max);
	}
}