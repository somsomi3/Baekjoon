import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int count =0;
			for(int j=N; j<=M; j++) {
//				String s = j.toString;
				String s = String.valueOf(j);
				
//				char c =s.charAt(j);
//				if(c=='0')count++;
			    for (int k = 0; k < s.length(); k++) {
			        if (s.charAt(k) == '0') {
			            count++;
			        }
			    }
			}
		    System.out.println(count);
		}
	}
}
