import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int sum = 0;
		int bonus = 0;
		for(int i=0; i<N; i++) {
			char c = s.charAt(i);
			
			if(c=='O') {
				sum+=(i+1);
				sum+= bonus;
				bonus++;
			}else if(c=='X') {
				bonus=0;
			}
		}
		
		System.out.println(sum);
		
	}
}
