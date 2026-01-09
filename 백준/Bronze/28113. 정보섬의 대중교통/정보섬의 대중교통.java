import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int x = 0;
		if(B>=N)x=B;
		else if(B<N)x=1000001;
		
		if(A==x)System.out.println("Anything");
		else if(A>x)System.out.println("Subway");
		else System.out.println("Bus");
	}
}
