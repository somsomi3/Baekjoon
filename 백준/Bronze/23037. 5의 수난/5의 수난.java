import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		int N = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		
		int sum =0;
		for(int i =0; i<s.length(); i++) {
			int a = s.charAt(i)-'0';
			int x = a*a*a*a*a;
			sum+=x;
		}
		System.out.println(sum);
	}
}
