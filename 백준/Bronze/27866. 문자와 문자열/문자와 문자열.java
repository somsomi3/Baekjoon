import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		char x =0;
		for(int i= 0; i<N; i++) {
			x = s.charAt(i);
		}
		System.out.println(x);
		
	}
}
