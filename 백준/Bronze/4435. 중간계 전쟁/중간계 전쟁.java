import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int cnt =1;
		while(T--> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//간달프
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
			int a4 = Integer.parseInt(st.nextToken());
			int a5 = Integer.parseInt(st.nextToken());
			int a6 = Integer.parseInt(st.nextToken());
			
			int sumA = a1+a2*2+a3*3+a4*3+a5*4+a6*10;
			st = new StringTokenizer(br.readLine());
			//사우론
			int b1 = Integer.parseInt(st.nextToken());
			int b2 = Integer.parseInt(st.nextToken());
			int b3 = Integer.parseInt(st.nextToken());
			int b4 = Integer.parseInt(st.nextToken());
			int b5 = Integer.parseInt(st.nextToken());
			int b6 = Integer.parseInt(st.nextToken());
			int b7 = Integer.parseInt(st.nextToken());
			
			int sumB = b1+b2*2+b3*2+b4*2+b5*3+b6*5+b7*10;
			
			if(sumA>sumB)System.out.println("Battle "+cnt+": Good triumphs over Evil");
			else if(sumA<sumB)System.out.println("Battle "+cnt+": Evil eradicates all trace of Good");
			else System.out.println("Battle "+cnt+ ": No victor on this battle field");
			
			cnt++;
		}
	}
}