import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		//항상짝수, 범위 초과 안하는듯.
		
		String s = br.readLine();
		
		int lSum =0;
		for(int i = 0; i<s.length()/2;i++) {
			int a = s.charAt(i)-'0';
			lSum +=a;
		}
		int rSum =0;
		for(int i =s.length()/2; i<s.length(); i++) {
			int b = s.charAt(i)-'0';
			rSum+=b;
		}
		System.out.println(lSum==rSum? "LUCKY":"READY");
	}
}
