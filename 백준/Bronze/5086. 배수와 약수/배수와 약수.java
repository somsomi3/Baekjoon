import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String s = br.readLine();
			if(s.equals("0 0"))break;
			
			String[] aa = s.split(" ");
			int a = Integer.parseInt(aa[0]);
			int b = Integer.parseInt(aa[1]);
			
			if(b>a&&b%a==0)System.out.println("factor");
			else if(a>b&&a%b==0)System.out.println("multiple");
			else if(a%b!=0||b%a!=0)System.out.println("neither");
		}
		
	}
}