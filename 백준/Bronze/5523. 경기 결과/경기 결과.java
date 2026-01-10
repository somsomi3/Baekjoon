import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int aSum =0;
		int bSum =0;
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			
			int B = Integer.parseInt(st.nextToken());
			
			if(A>B)aSum+=1;
			else if(B>A)bSum+=1;
		}

		System.out.println(aSum+" "+bSum);
	}
}
