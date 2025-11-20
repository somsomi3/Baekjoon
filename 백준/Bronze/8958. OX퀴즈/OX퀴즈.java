import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력받고, 숫자 활용하고
		
		// 그안에서 charAt사용하는 법 익히기.. 
		int N = Integer.parseInt(br.readLine());
		
		//반복되는 활동을 N을 기반으로 한다면 while을 쓰자.
		while(N-->0) {
			String s = br.readLine();
			int sum =0;
			int go = 0;
			
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='O') {
					go++;
					sum+=go;
				}else {
					go =0;
				}
			}
			System.out.println(sum);
		}
	}
}