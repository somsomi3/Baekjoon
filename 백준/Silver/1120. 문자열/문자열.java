import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		String t = st.nextToken();
		
		int min = 51;
		
		//문장 두개를 비교하는 길이 만큼 의 길이
		for(int i = 0; i< t.length()- s.length() + 1; i++) {
			int d = 0;
			
			//슬라이딩 윈도우
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(j) != t.charAt(i+j)) {
					d++;
				}
			}
			
			min = Math.min(min, d);
		}
		System.out.println(min);
	}
}
