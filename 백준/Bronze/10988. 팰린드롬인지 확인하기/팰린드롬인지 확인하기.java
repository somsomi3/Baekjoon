import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		boolean x = true;
		for(int i=0; i<s.length()/2;i++) {
//			if(i!=s.length()-i-1)
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				x = false;
            }
		}
		if(x)System.out.println(1);
		else System.out.println(0);
	}
}