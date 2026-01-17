import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int N = s.length();
		int sum=0;
		
		if(s.charAt(0)=='0') {
			if(s.charAt(1)=='x') {
				//16진수
				//c - 'a' = 97 - 97 = 0
				//0 + 10 = 10

				for (int i = 2; i < N; i++) {
				    char c = s.charAt(i);
				    int v;
				    if ('0' <= c && c <= '9') v = c - '0';
				    else v = c - 'a' + 10;

				    sum = sum * 16 + v;
				}
				
			}else {
				//8진수
				//이전 자리값들이 자동으로 한 자리씩 밀림
				for (int i = 1; i < N; i++) {
				    sum = sum * 8 + (s.charAt(i) - '0');
				}
			}
		}
        else {
            sum = Integer.parseInt(s);
        }
		System.out.println(sum);
		
	}
}
