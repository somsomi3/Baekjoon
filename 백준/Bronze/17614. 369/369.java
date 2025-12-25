import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N =Integer.parseInt(br.readLine());
		
		int count =0;
		
		for(int i =1; i<=N; i++) {
			//for문 제어 변수는 절대 내부에서 변경하지 않는다
			int x = i;   // ← 복사본
			while(x>0) {
				if(x%10==3||x%10==6||x%10==9) {
					count++;
				}
				x =  x/10;
			}
		}
		System.out.println(count);
	}
}
