import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=1000; i<=9999; i++) {
			//각 숫자(i)마다 합 변수 초기화
			int ten = 0;
			int tentwo =0;
			int tensix =0;
			
			int x = i;

			while(x>0) {
				ten+=x%10;
				x/=10;
			}
			
			//진법마다 x를 다시 초기화
		    x = i;
			while(x>0) {
				tentwo+=x%12;
				x/=12;
			}
			
			//진법마다 x를 다시 초기화
		    x = i;
			while(x>0) {
				tensix+=x%16;
				x/=16;	
			}
			
			if(ten==tentwo&& ten==tensix) {
				System.out.println(i);
			}			
		}
	}
}
