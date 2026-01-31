import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt =0;
		for(int i=0; i<N; i++) {
			String s= br.readLine();
			
			int x = Integer.parseInt(s.substring(2));
			if(x<=90) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
