import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(!Character.isUpperCase(c)) {
				char x = Character.toUpperCase(c);
				sb.append(x);
			}else if(!Character.isLowerCase(c)) {
				char x = Character.toLowerCase(c);
				sb.append(x);
			}
		}
		System.out.println(sb);
		
	}
}
