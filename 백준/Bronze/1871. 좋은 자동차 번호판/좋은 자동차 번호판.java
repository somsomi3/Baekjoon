import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split("-");
			
			String xx = s[0];
			int result =0;
			for(int j =0; j<3; j++) {
				int x = xx.charAt(j)-'A';
				result = result*26+x;
			}
			
			int y = Integer.parseInt(s[1]);
			
			int ans = Math.abs(result-y);
			
			System.out.println(ans<=100? "nice":"not nice");
		}
	}
}
