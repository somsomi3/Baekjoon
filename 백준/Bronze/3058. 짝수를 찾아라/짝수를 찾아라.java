import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int min =100;
			int sum =0;
			for(int i =0; i<7; i++) {
		
				int a = Integer.parseInt(st.nextToken());
//				System.out.println("입력값"+a);

				if(a%2==0) {
					if(a<min)min=a;
					sum+= a;
				}

			}//for문 밖에, while 문 안에 출력하기
			System.out.print(sum+" ");
			System.out.println(min);
		}
		
	}
}
