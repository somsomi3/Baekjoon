import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s == null)break;// isnull은 어디에 쓰지?
			
			sb.append(s);
		}
		
		String[] s = sb.toString().split(","); 
		int sum = 0; 
		for (int i = 0; i < s.length; i++) { 
			sum += Integer.parseInt(s[i]);
			} 
		System.out.println(sum);
		} 
	}