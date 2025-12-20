import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int count =1;
		for(int i =0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (c==',')count++; 
		}
		System.out.println(count);
	}
}
