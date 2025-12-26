import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		if((x+y)%2==0&& (x-y)%2==0) {
			int a = (x+y)/2;
			int b = (x-y)/2;
			if(a<0||b<0)System.out.println(-1);
			else System.out.println(Math.max(a, b)+" "+Math.min(a, b));
		}else System.out.println(-1);	
	}
}
