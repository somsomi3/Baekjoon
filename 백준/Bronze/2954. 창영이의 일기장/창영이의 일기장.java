import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i <s.length(); i++) {
			char c = s.charAt(i);
			sb.append(c);
			if(c=='a'||c=='e'||c=='o'||c=='u'||c=='i') {
				i += 2;
			}
		}
		System.out.println(sb);
	}
}
