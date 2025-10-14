import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count =0;
		for(int i =0; i<N; i++) {
			String r = br.readLine();
			
			//시작점 하나 잡고, 그것과 다음c 비교하기..
			
			boolean[] arr = new boolean[26];
			//굳이 안채워도 기본값이 false?
			Arrays.fill(arr, false);
			
//			int prev =0;
			//문자열 끼리 비교할 것
			char prev =0;
			boolean ok = true; // 그룹 단어 여부

			for(int j = 0; j<r.length(); j++) {
				char c = r.charAt(j);
				if(c != prev) {
					if(arr[c-'a']) {
						ok = false;
						break;
					}else {
						arr[c-'a'] = true;

					}
					
				}prev =c;
			}if(ok) count++; 
		}System.out.println(count);
	}

}
