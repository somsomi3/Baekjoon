import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt =0;
		for(int i=1; i<=500; i++) {
			
			int x = i*i+N;
			int a = (int)Math.sqrt(x);
			
			if(a<=500 &&a>i &&a*a==x) {
				//A>B:  && a > i
				//정수 문제에서는 반드시 역검증해야해서: &&a*a==x
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
