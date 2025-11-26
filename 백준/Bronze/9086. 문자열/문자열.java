import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			String s = br.readLine();

			System.out.print(s.charAt(0));
			System.out.println(s.charAt(s.length()-1));
			
		}
	}
}