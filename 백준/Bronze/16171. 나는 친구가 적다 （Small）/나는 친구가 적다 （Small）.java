import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String t = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!Character.isDigit(c)) {
				sb.append(c);
			}
		}
		
		if(sb.toString().contains(t))System.out.println(1);
		else System.out.println(0);
	}
}
