import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//boolean배열 만들기?
//		boolean[] arr = new boolean[26];
		
		for(int i =0; i<N; i++) {
			//test 케이스 마다 초기화
			boolean[] arr = new boolean[26];
			
			String s = br.readLine();
			
            for(int j = 0; j < s.length(); j++) { //문자열 순회
                int t = s.charAt(j) - 'A';
                arr[t] = true;
            }
			
			int sum =0;
			for(int j =0; j<26; j++) {
				if(!arr[j]) {
					sum+= j+'A';
				}
			}
			System.out.println(sum);
		}
	}
}
