import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String x = br.readLine();
			if(x.equals("0"))break;
			
			StringTokenizer st = new StringTokenizer(x);
			
			int N = Integer.parseInt(st.nextToken());
		
			int z = 1;

			for(int i =0; i<N; i++) {
				int branch = Integer.parseInt(st.nextToken());
				int minuses = Integer.parseInt(st.nextToken());
				
				z =z*branch -minuses;
			}
		
			System.out.println(z);
			
		}
		
	}
}