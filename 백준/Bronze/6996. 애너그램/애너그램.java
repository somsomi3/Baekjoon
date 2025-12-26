import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String s = st.nextToken();
			String t = st.nextToken();
			
			if(s.length()==t.length()) {
				int[]countS = new int[26];
				for(int i =0; i<s.length(); i++) {
					int c = s.charAt(i)-'a';
					countS[c]++;
				}
				
				int[]countT = new int[26];
				for(int i =0; i<t.length(); i++) {
					int c = t.charAt(i)-'a';
					countT[c]++;
				}
				boolean flag = true;
				for(int i =0; i<26; i++) {
					if(countS[i]!=countT[i]) {
						flag = false;
					}
				}
				if(flag)System.out.println(s+" & "+t+" are anagrams.");
				//출력 실수 주의
				else
				    System.out.println(s + " & " + t + " are NOT anagrams.");
				
			}else {
				System.out.println(s+" & "+t+" are NOT anagrams.");
			}
			
		}
	}
}