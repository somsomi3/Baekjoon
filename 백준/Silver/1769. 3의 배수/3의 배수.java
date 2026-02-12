import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String s = br.readLine();	
		int cnt = 0;
        while(s.length() > 1) {
			int sum = 0;

            for(int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
			}
            //s를 갱신
            s = String.valueOf(sum);
            cnt++;
		}
		
		System.out.println(cnt);
		
        //while 문이 끝난 후, 남은 길이가 1인 문자열
		int result = s.charAt(0) - '0';
        
        if(result % 3 == 0) System.out.println("YES");
        else System.out.println("NO");
	}
}