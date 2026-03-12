import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i< T; i++) {
			String s = br.readLine();
			char f = Character.toUpperCase(s.charAt(0));
//			String z = s.charAt(0).toUpperCase();

			String ans = f + s.substring(1);
			
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
