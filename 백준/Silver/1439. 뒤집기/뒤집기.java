import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s= br.readLine();
		
		int count1 = 0;
		int count0 = 0;
		
		
		if(s.charAt(0)-'0'==0)count0++;
		if(s.charAt(0)-'0'==1)count1++;		
		
		for(int i=1; i<s.length(); i++) {
			int x = s.charAt(i)-'0';
			
			if(s.charAt(i)-'0'!=s.charAt(i-1)-'0' && s.charAt(i)-'0'==1 ) {
				count1++;
			}else if(s.charAt(i)-'0'!=s.charAt(i-1)-'0' && s.charAt(i)-'0'==0) {
				count0++;
			}
		}
		System.out.println(Math.min(count1, count0));
	}
}