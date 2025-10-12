
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();
		
		int[] arr = new int[26];
		for(int i =0; i<s.length(); i++) {
			char c = s.charAt(i);
			arr[c-'A']++;
			
		}
        int max = -1;
        char result = '?';
        
        for(int i =0; i<26; i++) {
        	if(arr[i]>max) {
        		max = arr[i];
                result = (char)(i + 'A'); 
        	}else if (arr[i]==max) {
        		   result = '?';
            }
        }

        System.out.println(result);
    }
}