import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) {
			int[] count = new int[10];// 0-9까지 있다.
			int a = Integer.parseInt(br.readLine());
			int cnt =0;
			while(a>0) {
				int x= a%10;
				a =a/10;
				
				count[x]++;
				
				
			}
			for(int j =0; j<10; j++) {
				if(count[j]!=0) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
		
	}
}
