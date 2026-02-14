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
			
			int stand = Integer.parseInt(st.nextToken());
			int minus = Integer.parseInt(st.nextToken());
			
			int z = stand- minus;
			if(N>1) {
				for(int i =1; i<N; i++) {
					int branch = Integer.parseInt(st.nextToken());
					int minuses = Integer.parseInt(st.nextToken());
					
					z =z*branch -minuses;
				}
			}
			System.out.println(z);
			
		}
		
	}
}
