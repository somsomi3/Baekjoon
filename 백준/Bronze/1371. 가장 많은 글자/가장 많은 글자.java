import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String
		
		int[] arr = new int[26];
		
		String s;
		while((s= br.readLine())!=null) {
			for(int i =0; i<s.length(); i++) {
//				int c = s.charAt(i)-'0';
//				arr[c]++;
				char ch = s.charAt(i);
	            if (ch >= 'a' && ch <= 'z') {
                   arr[ch - 'a']++;
	            }
			}
			
		}
		
		//최댓값을 구하고 나서 그 빈도를 따로 세어야함.
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, arr[i]);
        }
        

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] == max) {
                sb.append((char) ('a' + i));
            }
        }       
		
//		System.out.println(sb);
		System.out.println(sb.toString());
		
	}
}