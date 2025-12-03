import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		
		String s= br.readLine();
		
//		for(int i =0; i<26; i++) {
        for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)-'a']++;
		}
		for(int i =0; i<26; i++) {
			System.out.print(arr[i]+ " ");
		}
	}
}
