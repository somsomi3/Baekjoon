import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		
		String[] arr = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String[] brr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
		
		if(N>=60) {
			N%=60;
		}
		//위치보정
		String a = arr[(N+6)%10];
		String b = brr[(N+8)%12];
		
		sb.append(b).append(a);
		
		System.out.println(sb);
	}
}
