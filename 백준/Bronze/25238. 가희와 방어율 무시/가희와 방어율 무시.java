import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		int a = Integer.parseInt(st.nextToken());
//		int b = Integer.parseInt(st.nextToken());

		double a = Double.parseDouble(st.nextToken());
		double b = Double.parseDouble(st.nextToken());
		
		double x = (a*b)/100;
		a-=x;
		//double인 a값 출력= 97.441
		//System.out.print(a);
		
		if(a>=100)System.out.print(0);
		else System.out.print(1);
	}
}
