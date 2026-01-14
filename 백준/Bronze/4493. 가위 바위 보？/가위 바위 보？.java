import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int oneCount =0;
			int twoCount =0;
			
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String one = st.nextToken();
				String two = st.nextToken();
				
				if(one.equals("R")) {
					if(two.equals("S"))oneCount++;
					else if(two.equals("P"))twoCount++;
				}
				
				if(one.equals("S")) {
					if(two.equals("P"))oneCount++;
					else if(two.equals("R"))twoCount++;
				}
				
				if(one.equals("P")) {
					if(two.equals("R"))oneCount++;
					else if(two.equals("S"))twoCount++;
				}
				
				
			}
			if(oneCount>twoCount)System.out.println("Player 1");
			else if(oneCount<twoCount)System.out.println("Player 2");
			else System.out.println("TIE");
		}
	}
}