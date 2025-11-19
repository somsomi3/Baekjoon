import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//공백이 없는 경우에 어떻게 입력을 받을 것인가?
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int sum = 0;
		for(int i =0; i<N; i++) {
			sum += s.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}