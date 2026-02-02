import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = "Never gonna give you up";
		String b = "Never gonna let you down";
		String c = "Never gonna run around and desert you";
		String d = "Never gonna make you cry";
		String e = "Never gonna say goodbye";
		String f = "Never gonna tell a lie and hurt you";
		String g = "Never gonna stop";
		
		int N = Integer.parseInt(br.readLine());
		
		boolean flag = true;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			
			if(s.equals(a)||s.equals(b)||s.equals(c)||s.equals(d)||s.equals(e)||s.equals(f)||s.equals(g)) {
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		if(!flag)System.out.println("Yes");
		else System.out.println("No");
	}
}