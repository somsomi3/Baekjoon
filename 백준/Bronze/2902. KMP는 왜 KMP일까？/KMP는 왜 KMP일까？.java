import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String r = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append(r.charAt(0));
		for(int i =0; i<r.length(); i++) {
			
			if(r.charAt(i)=='-') {
				sb.append(r.charAt(i+1));
			}
		}
		System.out.println(sb);
	}

}
