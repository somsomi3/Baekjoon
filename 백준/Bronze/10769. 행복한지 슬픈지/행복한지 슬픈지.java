import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = br.readLine();
		
		boolean xx = false;
		int happy = 0;
		int sad = 0;
				
		for(int i= 0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(s.charAt(i)==':') {
				if(s.charAt(i+1)=='-') {
					if(s.charAt(i+2)==')') {
						happy++;
						xx = true;
					}else if(s.charAt(i+2)=='(') {
						sad++;
						xx = true;
					}
				}else continue;
			}else continue;
		}
		if(!xx)System.out.println("none");
		else if(happy==sad)System.out.println("unsure");
		else if(happy>sad)System.out.println("happy");
		else if(sad>happy)System.out.println("sad");
	}
}