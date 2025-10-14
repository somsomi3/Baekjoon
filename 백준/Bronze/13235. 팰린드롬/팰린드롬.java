import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String r = br.readLine();
		
		boolean ok = true;
		for(int i=0; i<r.length()/2; i++) {
//			if(r.length()%2!=0) {
//				//홀수이면..
//			}

			if(r.charAt(i)!=r.charAt(r.length()-1-i)) {
				ok= false;
				break;
			}
		}if(ok) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}			
	}
}