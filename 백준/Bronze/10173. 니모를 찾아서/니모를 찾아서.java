import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s.equals("EOI")) break;
			
			String ss = s.toLowerCase();
			StringBuilder sb = new StringBuilder();
			
			sb.append(ss);
			
			if(sb.toString().contains("nemo")) {
				System.out.println("Found");
			}else System.out.println("Missing");
		}	
	}
}
