import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		
		boolean M = false;
		boolean O = false;
		boolean B = false;
		boolean I = false;
		boolean S = false;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c=='M') {
				M = true;
			}else if(c=='O') {
				O = true;
			}else if(c=='B') {
				B = true;
			}else if(c=='I') {
				I = true;
			}if(c=='S') {
				S = true;
			}	
		}
		
		if(M&&O&&B&&I&&S)System.out.println("YES");
		else System.out.println("NO");
		
	}
}
