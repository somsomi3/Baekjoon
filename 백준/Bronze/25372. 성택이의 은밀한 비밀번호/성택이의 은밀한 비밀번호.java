import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i =0; i<n; i++) {
			String s = br.readLine();
			if(6<=s.length()&& s.length()<=9) {
				System.out.println("yes");
			}else System.out.println("no");
		}
		
	}
}
