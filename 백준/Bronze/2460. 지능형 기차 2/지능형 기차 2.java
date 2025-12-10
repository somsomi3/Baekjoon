import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		
		int sum = 0;
		int max =0;// 사람 수는 음수가 될 수 없다.
		
		for(int i =0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sum -=a;
			sum +=b;
			
			if(sum>max)max=sum;
		}
		
		System.out.println(max);
	}
}