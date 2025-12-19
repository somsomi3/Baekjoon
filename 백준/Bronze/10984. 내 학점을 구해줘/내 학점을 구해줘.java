import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int sum =0;
			double bsum =0;
			for(int i =1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				sum+=a;
				double b = Double.parseDouble(st.nextToken());
                bsum += a * b;
				
			}
            System.out.printf("%d %.2f\n", sum, bsum / sum);
		}
		
	}
}
