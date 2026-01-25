import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans= 0;
		while(N-->0) {
			String s = br.readLine();
			
			int[] count = new int[26];
			boolean flag = true;
			
			count[s.charAt(0)-'a']++;
			
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i-1)!=s.charAt(i)&&count[s.charAt(i)-'a']>0) {
					flag = false;
					break;
				}else{
					count[s.charAt(i)-'a']++;
				}
			}
			if(flag)
				ans++;	
		}
		System.out.println(ans);
	}
}
