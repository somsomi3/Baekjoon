import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = s.length();
		
		int x =1;
		for(int i =0; i<N; i++) {
			if(s.charAt(i)=='A') {
				if(x==1)x=2;
				else if(x==2)x=1;
				else continue;
			}else if(s.charAt(i)=='B') {
				if(x==2)x=3;
				else if(x==3)x=2;
				else continue;
			}else if(s.charAt(i)=='C') {
				if(x==3)x=1;
				else if(x==1)x=3;
				else continue;
			}
		}
		System.out.println(x);
		
	}
}
