import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int sum = 0;
		int select = 0;
		for(int i =0 ; i<s.length(); i++) {
			if(s.charAt(i)=='*') {
				select = i;
			}else {
				int x = s.charAt(i) - '0';
				
				if(i%2==0) sum+=x;
				else sum+= 3*x;
			}
			
		}
		for(int i = 0; i <= 9; i++) {
			int temp = sum;
			
			if(select % 2 == 0) temp += i;
			else temp += 3 * i;
			
			if(temp % 10 == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}