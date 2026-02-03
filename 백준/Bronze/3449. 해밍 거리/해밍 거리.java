import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			String s = br.readLine();
			String t = br.readLine();
			
			int distance =0;
			for(int i=0; i<s.length(); i++) {
				char sc = s.charAt(i);
				char tc = t.charAt(i);
				if(sc!=tc)distance++;
			}
			
			System.out.println("Hamming distance is "+distance+".");
		}
		
	}
}
