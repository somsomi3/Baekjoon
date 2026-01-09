import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x;
		int i =0;
		while((x =Integer.parseInt(br.readLine()))!=0) {
			StringBuilder sb = new StringBuilder();
			i++;
			sb.append(i+". ");
			int n1 = x*3;
			
			if(n1%2==0)sb.append("even ");
			else sb.append("odd ");
			
			int n2;
			if(n1%2==0)n2=n1/2;
			else n2=(n1+1)/2;
			
			int n3= n2*3;
			
			int n4= n3/9;
			sb.append(n4);
			
			System.out.println(sb);	

		}
	}
}
