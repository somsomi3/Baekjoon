import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = "CAMBRIDGE";
		
		char[] cc = new char[s.length()];
		
		for(int i =0; i<s.length(); i++) {
			cc[i] = s.charAt(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		String inin = br.readLine();

		for (int j = 0; j < inin.length(); j++) {   // 입력 문자열 기준
		    char c = inin.charAt(j);
		    boolean blocked = false;

		    for (int i = 0; i < s.length(); i++) {  // CAMBRIDGE 검사
		        if (c == cc[i]) {
		            blocked = true;
		            break;
		        }
		    }

		    if (!blocked) sb.append(c);
		}
		
		System.out.println(sb);
	}
}
